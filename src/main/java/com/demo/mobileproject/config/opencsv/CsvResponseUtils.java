package com.demo.mobileproject.config.opencsv;

import com.demo.mobileproject.sales.entity.ProductSmartphoneDetails;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.PrintWriter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsvResponseUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvResponseUtils.class);

    public static void writeCities(PrintWriter writer, List<ProductSmartphoneDetails> smartphoneDeatails)  {

        try {

            ColumnPositionMappingStrategy mapStrategy
                    = new ColumnPositionMappingStrategy();

            mapStrategy.setType(ProductSmartphoneDetails.class);
            mapStrategy.generateHeader();

            String[] columns = new String[]{"id","category","brand","phoneSeries","alsoKnownAs","networkTechnology","bodyDimensions","bodyWeight","bodyBuild","bodySIM","bodyOther","displayType","displaySize","displayResolution","displayProtection","displayOther","launchAnnounced","launchStatus","platformOS","platformChipset","platformCPU","platformGPU","memoryCardSlot","memoryInternal","mainCameraSingle","mainCameraDual","mainCameraFeature","mainCameraVideo","selfieCameraSingle","selfieCameraFeatures","selfieCameraVideo","soundLoudspeaker","sound3_5mmJack","commonsWLAN","commonsBluetooth","commonsGPS","commonsNFC","commonsRadio","commonsUBS","featuresSensors","batteryType","batteryCharging","batteryTalkTimeMusicPlay","miscColor","miscPrice","imageLocation"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv btcsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(smartphoneDeatails);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }

    }

    public static void writeCity(PrintWriter writer, ProductSmartphoneDetails smartphoneDeatails) {

        try {

            ColumnPositionMappingStrategy mapStrategy
                    = new ColumnPositionMappingStrategy();

            mapStrategy.setType(ProductSmartphoneDetails.class);

            String[] columns = new String[]{"id","category","brand","phoneSeries","alsoKnownAs","networkTechnology","bodyDimensions","bodyWeight","bodyBuild","bodySIM","bodyOther","displayType","displaySize","displayResolution","displayProtection","displayOther","launchAnnounced","launchStatus","platformOS","platformChipset","platformCPU","platformGPU","memoryCardSlot","memoryInternal","mainCameraSingle","mainCameraDual","mainCameraFeature","mainCameraVideo","selfieCameraSingle","selfieCameraFeatures","selfieCameraVideo","soundLoudspeaker","sound3_5mmJack","commonsWLAN","commonsBluetooth","commonsGPS","commonsNFC","commonsRadio","commonsUBS","featuresSensors","batteryType","batteryCharging","batteryTalkTimeMusicPlay","miscColor","miscPrice","imageLocation"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv btcsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(smartphoneDeatails);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }









   /* private static final CsvMapper mapper = new CsvMapper();
    public static <T> List<T> read(Class<T> clazz, InputStream stream) throws IOException {
        CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true);
        ObjectReader reader = mapper.readerFor(clazz).with(schema);
        return reader.<T>readValues(stream).readAll();
    }*/
}
