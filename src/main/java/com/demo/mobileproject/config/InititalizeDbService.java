package com.demo.mobileproject.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.demo.mobileproject.sales.dto.ExcelManyDto;
import com.demo.mobileproject.sales.dto.ExcelOneDto;
import com.demo.mobileproject.sales.entity.Brand;
import com.demo.mobileproject.sales.entity.Category;
import com.demo.mobileproject.sales.entity.Product;
import com.demo.mobileproject.sales.entity.ProductInstock;
import com.demo.mobileproject.sales.enums.BrandEnum;
import com.demo.mobileproject.sales.enums.CategoryNamesEnum;
import com.demo.mobileproject.sales.service.BrandService;
import com.demo.mobileproject.sales.service.CategoryService;
import com.demo.mobileproject.sales.service.ProductService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class InititalizeDbService {

	private static final Logger LOGGER = LogManager.getLogger(InititalizeDbService.class);

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;

	@Autowired
	ResourceLoader resourceLoader;

	@PostConstruct
	public void init() throws Exception {

		LOGGER.debug(" ---====================--- ");
		LOGGER.debug(" |   Data Initialized!   | ");
		LOGGER.debug(" ---====================--- ");

		prepareCategory();
		prepareBrand();
		prepareProducts();

	}

	private void prepareCategory() {
		if (categoryService.countCategoryTable() == 0) {
			try {
				LOGGER.debug(":: initialize ::  category ::");

				categoryService.createCategory(Category.builder().name(CategoryNamesEnum.ACCESSORY.getName()).build());
				categoryService.createCategory(Category.builder().name(CategoryNamesEnum.LAPTOP.getName()).build());
				categoryService.createCategory(Category.builder().name(CategoryNamesEnum.SPARES.getName()).build());
				categoryService.createCategory(Category.builder().name(CategoryNamesEnum.SMARTPHONE.getName()).build());
				categoryService.createCategory(Category.builder().name(CategoryNamesEnum.TABLET.getName()).build());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void prepareBrand() {
		if (brandService.countBrand() == 0) {
			LOGGER.debug(":: initialize ::  brand ::");

			brandService.createBrand(Brand.builder().name(BrandEnum.APPLE.getName()).build());
			brandService.createBrand(Brand.builder().name(BrandEnum.SAMSUNG.getName()).build());

		}
	}

	public void prepareProducts() {

		if (productService.countProduct() == 0) {

			try {
				LOGGER.debug(":: initialize :: productDetails  -   smartphone  ::");

				final Resource fileResource = resourceLoader.getResource("classpath:data/SmartPhone_DataEntry.csv");

				File file = fileResource.getFile();

				System.out.println("file.canRead()=" + file.canRead());
				System.out.println("file.isFile()=" + file.isFile());

				if (file.canRead() == true && file.canRead() == true) {
					readCSVFile(file.toPath());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void readCSVFile(Path filePath) {

		try (Reader reader = Files.newBufferedReader(filePath)) {

			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

			List<String[]> records = csvReader.readAll();

			List<ExcelOneDto> productListTemp = new ArrayList<>();

			System.out.println("..... start adding temp to DataObject \t record rows is..." + records.size());

			for (int row = 0; row < records.size(); row += 4) {

				List<ExcelManyDto> productInstockListTemp = new ArrayList<>();

				String[] record1 = records.get(row);
				String[] record2 = records.get(row + 1);
				String[] record3 = records.get(row + 2);
				String[] record4 = records.get(row + 3);

				productInstockListTemp.add(ExcelManyDto.builder().id(Integer.parseInt(record1[5])).color(record1[6])
						.memory(record1[7]).price(record1[8]).size(record1[9]).quantity(record1[10]).build());

				productInstockListTemp.add(ExcelManyDto.builder().id(Integer.parseInt(record2[5])).color(record2[6])
						.memory(record2[7]).price(record2[8]).size(record2[9]).quantity(record2[10]).build());

				productInstockListTemp.add(ExcelManyDto.builder().id(Integer.parseInt(record3[5])).color(record3[6])
						.memory(record3[7]).price(record3[8]).size(record3[9]).quantity(record3[10]).build());

				productInstockListTemp.add(ExcelManyDto.builder().id(Integer.parseInt(record4[5])).color(record4[6])
						.memory(record4[7]).price(record4[8]).size(record4[9]).quantity(record4[10]).build());

				productListTemp.add(ExcelOneDto.builder().id(Integer.parseInt(record1[0])).category(record1[1])
						.brand(record1[2]).itemName(record1[3]).otherName(record1[4])
						.excelManyDtoList(productInstockListTemp).build());

			}

			System.out.println("..... finish adding temp to DataObject");

			for (ExcelOneDto excelOneDto : productListTemp) {

				Product product = new Product();

				Category category = categoryService.findByCategoryName(excelOneDto.getCategory());
				if (null == category) {
					category = categoryService
							.createCategory(Category.builder().name(excelOneDto.getCategory()).build());
				}

				Brand brand = brandService.findByBrandName(excelOneDto.getBrand());
				if (null == brand) {
					brand = brandService.createBrand(Brand.builder().name(excelOneDto.getBrand()).build());
				}

				List<ProductInstock> pInstockList = new ArrayList<>();
				for (ExcelManyDto excelManyDto : excelOneDto.getExcelManyDtoList()) {
					pInstockList.add(new ProductInstock(excelManyDto, product));
				}

				product.setCategory(category);
				product.setBrand(brand);
				product.setItenName(excelOneDto.getItemName());
				product.setOtherName(excelOneDto.getOtherName());
				product.setProductInstockList(pInstockList);

				productService.createProduct(product);

			}

			System.out.println(" finish creating product list.....");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
