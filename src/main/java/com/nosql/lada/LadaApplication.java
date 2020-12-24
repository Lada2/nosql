package com.nosql.lada;

import com.nosql.lada.Aggregation.BrandCount;
import com.nosql.lada.MongoEntity.BrandMongo;
import com.nosql.lada.MongoEntity.CompanyMongo;
import com.nosql.lada.MongoEntity.FormMongo;
import com.nosql.lada.MongoEntity.VehicleMongo;
import com.nosql.lada.MongoRepository.BrandMongoRepository;
import com.nosql.lada.MongoRepository.CompanyMongoRepository;
import com.nosql.lada.MongoRepository.FormMongoRepository;
import com.nosql.lada.MongoRepository.VehicleMongoRepository;
import com.nosql.lada.SQLEntity.Brand;
import com.nosql.lada.SQLEntity.Company;
import com.nosql.lada.SQLEntity.Form;
import com.nosql.lada.SQLEntity.Vehicle;
import com.nosql.lada.SQLRepository.BrandRepository;
import com.nosql.lada.SQLRepository.CompanyRepository;
import com.nosql.lada.SQLRepository.FormRepository;
import com.nosql.lada.SQLRepository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class LadaApplication implements CommandLineRunner {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private BrandMongoRepository brandMongoRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyMongoRepository companyMongoRepository;

    @Autowired
    private FormRepository formRepository;
    @Autowired
    private FormMongoRepository formMongoRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleMongoRepository vehicleMongoRepository;

    public static void main(String[] args) {
        SpringApplication.run(LadaApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        // sqlTest();
       //  mongoTest();
       // speedMeasurement();
      //  migrationFromSqlToMongo();
        //  migrationFromMongoToSql();
        //replication();
        aggregation();
    }

    public void sqlTest() {
        //form
        Form form = new Form("3", "спортивная", "автомобиль, максимальна скорость которого больше 200 км/час");

        formRepository.save(new Form("1", "легковая", "автомобиль весом до 700 кг"));
        formRepository.save(new Form("2", "грузовая", "автомобиль весом от 700 кг"));
        formRepository.save(new Form("1", "легковая", "автомобиль весом до 800 кг"));
        formRepository.save(form);
        for (Form f : formRepository.findAll()) {
            System.out.println(f.toString());
        }
        formRepository.deleteById("2");
        for (Form f : formRepository.findAll()) {
            System.out.println(f.toString());
        }
        for (Form f : formRepository.findAllByName("легковая")) {
            System.out.println(f.toString());
        }


        //brand
        Brand brand = new Brand("2", "BMW", "Популярный немецкий бренд", "Германия", 1000000);

        brandRepository.save(new Brand("1", "ЗАЗ", "национальный автомобиль", "Украина", 3));
        brandRepository.save(new Brand("2", "Reno", "Бренд основанный з 1991 года", "Украина", 100000));
        brandRepository.save(new Brand("3", "Tesla", "Электроавтомобиль", "США", 500000));
        brandRepository.save(brand);
        for (Brand b : brandRepository.findAll()) {
            System.out.println(b.toString());
        }
        brandRepository.deleteById("2");
        for (Brand b : brandRepository.findAll()) {
            System.out.println(b.toString());
        }

        for (Brand b : brandRepository.findAllByName("BMW")) {
            System.out.println(b.toString());
        }

        //company
        Company company = new Company("1", "BMW Corporation", "страна Германия...", 1542, "Ангела Меркель");

        companyRepository.save(new Company("1", "BMW Production", "страна Германия...", 1542, "Ангела Меркель"));
        companyRepository.save(new Company("2", "Харьковский автозавод", "страна Харьков...", 5412, "Геннадий Кернес"));
        companyRepository.save(company);
        for (Company c : companyRepository.findAll()) {
            System.out.println(c.toString());
        }
        companyRepository.deleteById("2");
        for (Company c : companyRepository.findAll()) {
            System.out.println(c.toString());
        }

        for (Company c : companyRepository.findAllByCompanyName("легковая")) {
            System.out.println(c.toString());
        }

        vehicleRepository.save(new Vehicle("1", "BMW X5", 1053000.0, "black", 100.5, 2015, brand, company, form));

    }

    public void mongoTest() {
        FormMongo form = new FormMongo("3", "спортивная", "автомобиль, максимальна скорость которого больше 200 км/час");

        BrandMongo brand = new BrandMongo("2", "BMW", "Популярный немецкий бренд", "Германия", 1000000);

        CompanyMongo company = new CompanyMongo("1", "BMW Corporation", "страна Германия...", 1542, "Ангела Меркель");
        vehicleMongoRepository.save(new VehicleMongo("6", "Test1", 1053000.0, "black", 100.5, 2015, brand, company, form));
        vehicleMongoRepository.save(new VehicleMongo("7", "Test2", 1553000.0, "red", 10.5, 2018, brand, company, form));
        vehicleMongoRepository.save(new VehicleMongo("8", "Test3", 1158000.0, "black", 100.5, 2015, brand, company, form));
        vehicleMongoRepository.save(new VehicleMongo("9", "Test4", 1158000.0, "black", 100.5, 2015, brand, company, form));
        vehicleMongoRepository.save(new VehicleMongo("10", "Test5", 1158000.0, "black", 100.5, 2015, brand, company, form));

        formMongoRepository.save(new FormMongo("6", "test1", "автомобиль, максимальна скорость которого больше 200 км/час"));
        formMongoRepository.save(new FormMongo("7", "test2", "автомобиль, максимальна скорость которого больше 200 км/час"));
        formMongoRepository.save(new FormMongo("8", "test3", "автомобиль, максимальна скорость которого больше 200 км/час"));
        formMongoRepository.save(new FormMongo("9", "test4", "автомобиль, максимальна скорость которого больше 200 км/час"));
        formMongoRepository.save(new FormMongo("10", "test5", "автомобиль, максимальна скорость которого больше 200 км/час"));




        /*for (VehicleMongo v : vehicleMongoRepository.findAll()) {
            System.out.println(v.toString());
        }
        for (VehicleMongo v : vehicleMongoRepository.findAllByName("BMW X5")) {
            System.out.println(v.toString());
        }
        for (VehicleMongo v : vehicleMongoRepository.findAllByPriceGreaterThanEqual(1500000.0)) {
            System.out.println(v.toString());
        }
        vehicleMongoRepository.deleteAllByName("BMW X6");
        for (VehicleMongo v : vehicleMongoRepository.findAll()) {
            System.out.println(v.toString());
        }*/
    }

    public void speedMeasurement() {
        Form form = formRepository.findById("3").get();
        Brand brand = brandRepository.findById("1").get();
        Company company = companyRepository.findById("1").get();

        Long startTime = System.nanoTime();
        for (Integer i = 0; i < 100; i++) {
            vehicleRepository.save(new Vehicle(i.toString(), "BMW X5" + i, 1053000.0 + (i * 523) % 100000000, "black", 100.5, 2015, brand, company, form));
        }
        Long endTime = System.nanoTime();
        System.out.print("Insert into SQL took:");
        System.out.println(endTime - startTime);

        FormMongo formMongo = new FormMongo("3", "спортивная", "автомобиль, максимальна скорость которого больше 200 км/час");
        BrandMongo brandMongo = new BrandMongo("2", "BMW", "Популярный немецкий бренд", "Германия", 1000000);
        CompanyMongo companyMongo = new CompanyMongo("1", "BMW Corporation", "страна Германия...", 1542, "Ангела Меркель");
        startTime = System.nanoTime();
        for (Integer i = 0; i < 100; i++) {
            vehicleMongoRepository.save(new VehicleMongo(i.toString(), "BMW X5", 1053000.0 + (i * 523) % 100000000, "black", 100.5, 2015, brandMongo, companyMongo, formMongo));
        }
        endTime = System.nanoTime();
        System.out.print("Insert into Mongo took:");
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        vehicleRepository.findAll();
        endTime = System.nanoTime();
        System.out.print("Select into SQL took:");
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        vehicleMongoRepository.findAll();
        endTime = System.nanoTime();
        System.out.print("Select into Mongo took:");
        System.out.println(endTime - startTime);

    }

    public void migrationFromSqlToMongo() {
        List<Brand> brands = brandRepository.findAll();
        for (Brand b : brands) {
            Optional<BrandMongo> brandMongo = brandMongoRepository.findFirstByName(b.getName());
            if (brandMongo.isEmpty()) {
                brandMongoRepository.save(new BrandMongo(b.getId(), b.getName(), b.getDescription(), b.getCountry(), b.getPopularity()));
            }
        }
        List<Company> companies = companyRepository.findAll();
        for (Company c : companies) {
            Optional<CompanyMongo> companyMongo = companyMongoRepository.findFirstByCompanyName(c.getCompanyName());
            if (companyMongo.isEmpty()) {
                companyMongoRepository.save(new CompanyMongo(c.getId(), c.getCompanyName(), c.getAddress(), c.getPhoneNumber(), c.getManager()));
            }
        }

        List<Form> forms = formRepository.findAll();
        for (Form f : forms) {
            Optional<FormMongo> formMongo = formMongoRepository.findFirstByName(f.getName());
            if (formMongo.isEmpty()) {
                formMongoRepository.save(new FormMongo(f.getId(), f.getName(), f.getDescription()));
            }
        }

        List<Vehicle> vehicles = vehicleRepository.findAll();
        for (Vehicle v : vehicles) {
            Optional<VehicleMongo> vehicleMongo = vehicleMongoRepository.findFirstByName(v.getName());
            if (vehicleMongo.isEmpty()) {
                Optional<BrandMongo> brandMongo = brandMongoRepository.findFirstByName(v.getBrand().getName());
                Optional<CompanyMongo> companyMongo = companyMongoRepository.findFirstByCompanyName(v.getCompany().getCompanyName());
                Optional<FormMongo> formMongo = formMongoRepository.findFirstByName(v.getForm().getName());

                vehicleMongoRepository.save(new VehicleMongo(v.getId(), v.getName(), v.getPrice(), v.getColor(), v.getMileage(), v.getManufactureYear(), brandMongo.get(), companyMongo.get(), formMongo.get()));
            }
        }

    }

    public void migrationFromMongoToSql() {
        List<BrandMongo> brands = brandMongoRepository.findAll();
        for (BrandMongo b : brands) {
            Optional<Brand> brand = brandRepository.findFirstByName(b.getName());
            if (brand.isEmpty()) {
                brandRepository.save(new Brand(b.getId(), b.getName(), b.getDescription(), b.getCountry(), b.getPopularity()));
            }
        }

        List<CompanyMongo> companies = companyMongoRepository.findAll();
        for (CompanyMongo c : companies) {
            Optional<Company> company = companyRepository.findFirstByCompanyName(c.getCompanyName());
            if (company.isEmpty()) {
                companyRepository.save(new Company(c.getId(), c.getCompanyName(), c.getAddress(), c.getPhoneNumber(), c.getManager()));
            }
        }

        List<FormMongo> forms = formMongoRepository.findAll();
        for (FormMongo f : forms) {
            Optional<Form> form = formRepository.findFirstByName(f.getName());
            if (form.isEmpty()) {
                formRepository.save(new Form(f.getId(), f.getName(), f.getDescription()));
            }
        }

        List<VehicleMongo> vehicles = vehicleMongoRepository.findAll();
        for (VehicleMongo v : vehicles) {
            Optional<Vehicle> vehicle = vehicleRepository.findFirstByName(v.getName());
            if (vehicle.isEmpty()) {
                Optional<Brand> brand = brandRepository.findFirstByName(v.getBrandMongo().getName());
                Optional<Company> company = companyRepository.findFirstByCompanyName(v.getCompanyMongo().getCompanyName());
                Optional<Form> form = formRepository.findFirstByName(v.getFormMongo().getName());

                vehicleRepository.save(new Vehicle(v.getId(), v.getName(), v.getPrice(), v.getColor(), v.getMileage(), v.getManufactureYear(), brand.get(), company.get(), form.get()));
            }
        }

    }

    public void replication() throws InterruptedException {
        brandMongoRepository.deleteAll();
        long startTime = System.nanoTime();
        for (Integer i = 0; i < 10000; i++) {
            save
                    (new BrandMongo
                            ('2'+i.toString(), "BMWT"+i.toString(), "Популярный немецкий бренд", "Германия", 1000000+(i*51332)%35333332)
                    );
        }
        long endTime = System.nanoTime();
        System.out.println("Insert: " + (double) (endTime - startTime) / 1000000000);
        startTime = System.nanoTime();
        brandMongoRepository.findAll();
        endTime = System.nanoTime();
        System.out.println("Select: " + (double) (endTime - startTime) / 1000000000);
    }

    public BrandMongo save(BrandMongo brandMongo) throws InterruptedException {
        int retries = 3;
        while (retries > 0) {
            try {
                return brandMongoRepository.save(brandMongo);
            } catch (Exception e) {
                retries--;
                Thread.sleep(1000);
            }
        }
        System.out.println("Error to insert document");
        return null;
    }

    public void aggregation(){
       //1Agg
        long startTime = System.nanoTime();
       /* for (BrandCount b : brandMongoRepository.countAllByCountry()) {
            System.out.println(b);
        }*/
        brandMongoRepository.countAllByCountry();
        long endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);
//1Not
        startTime = System.nanoTime();
        List<BrandMongo> temp = brandMongoRepository.findAll();
        HashMap<String, Integer> countCountry = new HashMap<>();
        for( BrandMongo b : temp) {
            Integer frequency = countCountry.get(b.getCountry());
            countCountry.put(b.getCountry(), frequency == null ? 1 : frequency + 1);
        }
        List<BrandCount> result = new ArrayList<BrandCount>();
        for (Map.Entry<String, Integer> entry : countCountry.entrySet()) {
            result.add(new BrandCount(entry.getKey(),entry.getValue()));
        }
/*
        for (BrandCount b : result) {
            System.out.println(b);
        }
       */
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

//2Agg
        startTime = System.nanoTime();
       /* for (BrandCount b : brandMongoRepository.countAllByCountryAndPopularityGreaterThan()) {
            System.out.println(b);
        }
             */
        brandMongoRepository.countAllByCountryAndPopularityGreaterThan();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

//2Not
        startTime = System.nanoTime();
        temp = brandMongoRepository.findAll();
        HashMap<String, Integer> countCountryWithMatch = new HashMap<>();
        for( BrandMongo b : temp) {
            if (b.getPopularity() > 1500000) {
                Integer frequency = countCountryWithMatch.get(b.getCountry());
                countCountryWithMatch.put(b.getCountry(), frequency == null ? 1 : frequency + 1);
            }
        }
         result = new ArrayList<BrandCount>();
        for (Map.Entry<String, Integer> entry : countCountryWithMatch.entrySet()) {
            result.add(new BrandCount(entry.getKey(),entry.getValue()));
        }
        /*
        for (BrandCount b : result) {
            System.out.println(b);
        }

         */
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //3 Agg
        startTime = System.nanoTime();
       /* for (BrandMongo b : brandMongoRepository.matchCountry()) {
            System.out.println(b);
        }
        */
        brandMongoRepository.matchCountry();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

//3Not
        startTime = System.nanoTime();
        //temp = brandMongoRepository.findAllByCountry("Германия");
        brandMongoRepository.findAllByCountry("Германия");
        /*for (BrandMongo b : temp) {
            System.out.println(b);
        }*/
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

//4 Agg
        startTime = System.nanoTime();
       /* for (BrandMongo b : brandMongoRepository.matchPopularityGreaterThan()) {
            System.out.println(b);
        }
        */
        brandMongoRepository.matchPopularityGreaterThan();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //4Not
        startTime = System.nanoTime();
        /*for (BrandMongo b : brandMongoRepository.findAllByPopularityGreaterThan(1000)) {
            System.out.println(b);
        }*/
        brandMongoRepository.findAllByPopularityGreaterThan(1000);
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        //5Agg
        startTime = System.nanoTime();
       /* for (String s : companyMongoRepository.findAllManager()) {
            System.out.println(s);
        }*/
        companyMongoRepository.findAllManager();
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

//5Not
        startTime = System.nanoTime();
        List<CompanyMongo> temp2 = companyMongoRepository.findAll();
        List<String> res = new ArrayList<>();
        for (CompanyMongo b : temp2) {
            res.add(b.getManager());
        }
        /*for (String s : res) {
            System.out.println(s.toString());
        }*/
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);



    }

}
