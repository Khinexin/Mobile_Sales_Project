package com.demo.mobileproject.config;

import com.demo.mobileproject.sales.entity.Brand;
import com.demo.mobileproject.sales.entity.Category;
import com.demo.mobileproject.sales.entity.ProductSmartphoneDetails;
import com.demo.mobileproject.sales.enums.BrandEnum;
import com.demo.mobileproject.sales.enums.CategoryNamesEnum;
import com.demo.mobileproject.sales.service.BrandService;
import com.demo.mobileproject.sales.service.CategoryService;
import com.demo.mobileproject.sales.service.ProductSmartphoneDetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class InititalizeDbService {

    private static final Logger LOGGER = LogManager.getLogger(InititalizeDbService.class);


    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductSmartphoneDetailsService productSmartphoneDetailsService;
    @Autowired
    private BrandService brandService;

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

                categoryService.createCategory(new Category(CategoryNamesEnum.SMARTPHONE.getName()));
                categoryService.createCategory(new Category(CategoryNamesEnum.TABLET.getName()));
                categoryService.createCategory(new Category(CategoryNamesEnum.LAPTOP.getName()));
                categoryService.createCategory(new Category(CategoryNamesEnum.ACCESSORY.getName()));
                categoryService.createCategory(new Category(CategoryNamesEnum.SPARES.getName()));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void prepareBrand(){
        if(brandService.countBrand() == 0){
            LOGGER.debug(":: initialize ::  brand ::");

            brandService.saveBrand(new Brand(BrandEnum.APPLE.getName()));
            brandService.saveBrand(new Brand(BrandEnum.SAMSUNG.getName()));

        }
    }



    private void prepareProducts() {
        if (productSmartphoneDetailsService.countProduct() == 0) {
            try {
                LOGGER.debug(":: initialize :: productDetails  -   smartphone  ::");

                List<List<String>> records = new ArrayList<>();
//                try (Scanner scanner = new Scanner(new File("SmartPhone_DataEntry.csv"));) {

                File file = ResourceUtils.getFile("classpath:SmartPhone_DataEntry.csv");
                try (Scanner scanner = new Scanner(file)) {

                    while (scanner.hasNextLine()) {
                        records.add(getRecordFromLine(scanner.nextLine()));
                    }
                }

                for (List<String> recordRow: records) {

                    ProductSmartphoneDetails smartphoneDeatails = new ProductSmartphoneDetails();

                    Object[] tempRECORD = recordRow.toArray();

                    smartphoneDeatails.setCategory((String) tempRECORD[1]);
                    smartphoneDeatails.setBrand((String) tempRECORD[2]);

                    smartphoneDeatails.setPhoneSeries((String) tempRECORD[3]);
                    smartphoneDeatails.setAlsoKnownAs((String) tempRECORD[4]);

                    smartphoneDeatails.setNetworkTechnology((String) tempRECORD[5]);

//                    smartphoneDeatails.setBodyDimensions((String) tempRECORD[6]);
//                    smartphoneDeatails.setBodyWeight((String) tempRECORD[7]);
//                    smartphoneDeatails.setBodyBuild((String) tempRECORD[8]);
//                    smartphoneDeatails.setBodySIM((String)tempRECORD[9]);
//                    smartphoneDeatails.setBodyOther((String)tempRECORD[10]);
//
//                    smartphoneDeatails.setDisplayType((String)tempRECORD[11]);
//                    smartphoneDeatails.setDisplaySize((String)tempRECORD[12]);
//                    smartphoneDeatails.setDisplayResolution((String)tempRECORD[13]);
//                    smartphoneDeatails.setDisplayProtection((String)tempRECORD[14]);
//                    smartphoneDeatails.setDisplayOther((String)tempRECORD[15]);
//
//                    smartphoneDeatails.setLaunchAnnounced((String)tempRECORD[16]);
//                    smartphoneDeatails.setLaunchStatus((String)tempRECORD[17]);
//
//                    smartphoneDeatails.setPlatformOS((String)tempRECORD[18]);
//                    smartphoneDeatails.setPlatformChipset((String)tempRECORD[19]);
//                    smartphoneDeatails.setPlatformCPU((String)tempRECORD[20]);
//                    smartphoneDeatails.setPlatformGPU((String)tempRECORD[21]);
//
//                    smartphoneDeatails.setMemoryCardSlot((String)tempRECORD[22]);
//                    smartphoneDeatails.setMemoryInternal((String)tempRECORD[23]);
//
//                    smartphoneDeatails.setMainCameraSingle((String)tempRECORD[24]);
//                    smartphoneDeatails.setMainCameraDual((String)tempRECORD[25]);
//                    smartphoneDeatails.setMainCameraFeature((String)tempRECORD[26]);
//                    smartphoneDeatails.setMainCameraVideo((String)tempRECORD[27]);
//
//                    smartphoneDeatails.setSelfieCameraSingle((String)tempRECORD[28]);
//                    smartphoneDeatails.setSelfieCameraFeatures((String)tempRECORD[29]);
//                    smartphoneDeatails.setSelfieCameraVideo((String)tempRECORD[30]);
//
//                    smartphoneDeatails.setSoundLoudspeaker((String)tempRECORD[31]);
//                    smartphoneDeatails.setSound3_5mmJack((String)tempRECORD[32]);
//
//                    smartphoneDeatails.setCommonsWLAN((String)tempRECORD[33]);
//                    smartphoneDeatails.setCommonsBluetooth((String)tempRECORD[34]);
//                    smartphoneDeatails.setCommonsGPS((String)tempRECORD[35]);
//                    smartphoneDeatails.setCommonsNFC((String)tempRECORD[36]);
//                    smartphoneDeatails.setCommonsRadio((String)tempRECORD[37]);
//                    smartphoneDeatails.setCommonsUBS((String)tempRECORD[38]);
//
//                    smartphoneDeatails.setFeaturesSensors((String)tempRECORD[39]);
//
//                    smartphoneDeatails.setBatteryType((String)tempRECORD[40]);
//                    smartphoneDeatails.setBatteryCharging((String)tempRECORD[41]);
//                    smartphoneDeatails.setBatteryTalkTimeMusicPlay((String)tempRECORD[42]);
//
//                    smartphoneDeatails.setMiscColor((String)tempRECORD[43]);
//                    smartphoneDeatails.setMiscPrice((String)tempRECORD[44]);
//
//                    smartphoneDeatails.setImageLocation((String) tempRECORD[45]);

                    productSmartphoneDetailsService.createProduct(smartphoneDeatails);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}
