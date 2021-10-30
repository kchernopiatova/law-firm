package com.solvd.lawfirm;

import com.solvd.lawfirm.cases.ClosedCase;
import com.solvd.lawfirm.cases.CurrentCase;
import com.solvd.lawfirm.exception.InvalidDateException;
import com.solvd.lawfirm.infrastructure.*;
import com.solvd.lawfirm.people.*;
import com.solvd.lawfirm.structure.Service;
import com.solvd.lawfirm.serviceclass.*;
import com.solvd.lawfirm.structure.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) throws IOException {

        LOGGER.info(Service.CIVIL);
        System.out.println();

        Lawyer andrew = new Lawyer("Andrew", "Wise", LocalDate.of(1985, 5, 1));
        Lawyer ivan = new Lawyer("Ivan", "Sly", LocalDate.of(1960, 10, 3));
        Lawyer lilian = new Lawyer("Lilian", "Cragun", LocalDate.of(1989, 1, 20));

        andrew.setExperience(5);
        ivan.setExperience(21);

        ivan.setOnWork(true);
        lilian.setOnWork(false);

        Set<Service> andrewService = new HashSet<>();
        andrewService.add(Service.CRIMINAL);
        andrewService.add(Service.INTELLECT);

        Set<Service> lilianService = new HashSet<>();
        lilianService.add(Service.CIVIL);

        Set<Service> ivanService = new HashSet<>();
        ivanService.addAll(andrewService);
        ivanService.addAll(lilianService);

        andrew.setService(andrewService);
        ivan.setService(ivanService);
        lilian.setService(lilianService);

        LOGGER.info(andrew);
        System.out.println();

        LOGGER.info("Andrew's salary: " + andrew.salary());
        System.out.println();

        Set<Lawyer> court1Lawyer = new HashSet<>();
        court1Lawyer.add(andrew);
        court1Lawyer.add(ivan);

        Set<Lawyer> court2Lawyer = new HashSet<>();
        court2Lawyer.add(lilian);

        Set<Lawyer> court3Lawyer = new HashSet<>();
        court3Lawyer.add(lilian);
        court3Lawyer.add(ivan);

        Court malinovka = new Court("Minsk", "malinovaya 2", "Malinovka", 13, court1Lawyer);
        Court central = new Court("Brest", "masherova 2", "Centralny", 8, court2Lawyer);
        Court angarskaya = new Court("Minsk", "vaneeva 2", "Angarskaya", 4, court3Lawyer);

        LOGGER.info(central);
        System.out.println();

        Judge misha = new Judge("Misha", "Hart", LocalDate.of(1970, 11, 6), malinovka);
        Judge olga = new Judge("Olga", "Prigod", LocalDate.of(1990, 6, 15), central);
        Judge sveta = new Judge("Sveta", "Novik", LocalDate.of(1984, 1, 29), angarskaya);

        LOGGER.info(olga);
        System.out.println();

        Client oleg = new Client("Oleg", "Shinoda");
        Client mike = new Client("Mike", "Adams");

        oleg.setCaseCategory("Civil");

        oleg.haveConsultation();
        mike.haveConsultation();
        System.out.println();

        oleg.setLawyer(ivan);
        mike.setLawyer(lilian);

        LOGGER.info(oleg);
        System.out.println();

        Computer personal = new Computer(10, 500, "HP");
        Computer portable = new Computer(3, 380, "Lenovo");
        Phone directorPhone = new Phone(2, 300, "52920");
        Phone accountantPhone = new Phone(5, 140, "473930");
        Printer printer = new Printer(2, 400, true);

        personal.setOnGuarantee(true);
        accountantPhone.setOnGuarantee(true);
        printer.setOnGuarantee(false);

        personal.buyEquipment(5);
        System.out.println();

        LOGGER.info(personal);
        System.out.println();

        Set<Department> office1Department = new HashSet<>();
        office1Department.add(Department.HR);
        office1Department.add(Department.QA);

        Set<Department> office2Department = new HashSet<>();
        office2Department.add(Department.WEB);
        office2Department.add(Department.QA);

        Map<Integer, Equipment> office1Equipment = new HashMap<>();
        office1Equipment.put(1, directorPhone);
        office1Equipment.put(2, personal);

        Map<Integer, Equipment> office2Equipment = new HashMap<>();
        office2Equipment.put(1, accountantPhone);
        office2Equipment.put(2, portable);
        office2Equipment.put(3, printer);

        Set<Lawyer> office1Lawyer = new HashSet<>();
        office1Lawyer.add(andrew);
        office1Lawyer.add(ivan);

        Set<Lawyer> office2Lawyer = new HashSet<>();
        office2Lawyer.add(lilian);

        Office theFirst = new Office("Brest", "Masherova 11", LocalDate.of(2003, 5, 8),
                office1Equipment, office1Lawyer, office1Department);
        Office theSecond = new Office("Minsk", "Vaneeva 2", LocalDate.of(2018, 1, 3),
                office2Equipment, office2Lawyer, office2Department);

        LOGGER.info(theFirst);
        System.out.println();

        LOGGER.info("The offices are working? " + theFirst.isWorking(WeekDay.TUESDAY));

        boolean isHoliday = true;
        LOGGER.info("The offices are working? " + theSecond.isWorking(isHoliday));
        System.out.println();

        CurrentCase case1 = new CurrentCase(mike);
        CurrentCase case2 = new CurrentCase(oleg);
        case2.setLawyer(ivan);

        LOGGER.info(case2);
        System.out.println();

        ClosedCase case1267 = new ClosedCase("Civil", ivan);
        ClosedCase case3719 = new ClosedCase("Criminal", lilian, false);
        ClosedCase case2617 = new ClosedCase("Civil", andrew);

        LOGGER.info("The number of successful cases: " + ClosedCase.successfulCase);
        System.out.println();

        ServicePrice lawyerService = new ServicePrice();

        LOGGER.info("The cost of lawyer service on this case wil be " + lawyerService.calculateLawService(oleg, central));

        ServicePrice totalPrice = new ServicePrice();

        LOGGER.info("The cost of all service for this clients is " + totalPrice.calculateAllServices(oleg, mike));
        System.out.println();

        Set<String> docs1 = new TreeSet<>();
        docs1.add("delo1");
        docs1.add("pasport");

        Equipment iphone = new Phone(4, 40, "472892");
        ControlClass.equipmentPurchase(iphone, 6);
        System.out.println();

        ControlDeviceImpl test1 = new ControlDeviceImpl();
        test1.useEquipment(portable);
        System.out.println();

        CountStaffImpl test2 = new CountStaffImpl();
        test2.countLawyer(theSecond);
        System.out.println();

        PersonSpeakImpl test3 = new PersonSpeakImpl();
        test3.speakTest(mike);
        System.out.println();

        WorkingCheckImpl test4 = new WorkingCheckImpl();
        test4.workingTimeCheck(theFirst);
        System.out.println();

        Staff person = new Lawyer();
        try {
            person.setDob(LocalDate.of(2024, 10, 16));
        } catch (InvalidDateException e) {
            LOGGER.error(e.getMessage());
        } finally {
            LOGGER.info("The operation is finished");
        }
        System.out.println();

        List<String> lawyerNames = new ArrayList<>();
        lawyerNames.add("John Doe");
        lawyerNames.add("Jack Golt");
        lawyerNames.add("Julia Swat");

        Accounting<String> lawyerAccounting = new Accounting<>();
        lawyerAccounting.print(lawyerNames);
        LOGGER.info("The number of lawyers: " + lawyerAccounting.count(lawyerNames));
        System.out.println();

        Birthday<Judge> check = new Birthday<>(olga);
        LOGGER.info(check.birthdayPerson(olga));
        System.out.println();

        SumSpent<Computer> checkSumSpent = new SumSpent<>(personal);
        LOGGER.info("The cost of computers is: " + checkSumSpent.calculate());
        System.out.println();

        try (Resource resources = new Resource()) {
            LOGGER.info("The end of the program");
        }

        LOGGER.info("Creating new branch");
        LOGGER.info("Resolving conflict");

        LOGGER.info("Adding new line");
        System.out.println();

        CEO chris = CEO.createInstance("Vladislav", "Kot", LocalDate.of(1980, 2, 6));
        System.out.println(chris);

        for (Department element : office1Department) {
            switch (element) {
                case QA:
                    LOGGER.info("There is QA department");
                    break;
                case HR:
                    LOGGER.info("There is HR department");
                    break;
                case WEB:
                    LOGGER.info("There is Web department");
                    break;
            }
        }

        String fileName = "src/main/resources/text.txt";
        String text = FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
        text = text.toLowerCase(Locale.ROOT);

        Map<String, Integer> words = new TreeMap<>();
        String delimeter = "[^a-zA-Z-’']";

        for (String word : text.split(delimeter)) {
            int wordAmount = StringUtils.countMatches(text, word);
            words.put(word, wordAmount);
        }

        Map<String, Integer> sortedWords = WordsCounting.sortByComparator(words);
        System.out.println(sortedWords);

        StringBuilder stringToFile = new StringBuilder();
        for (Map.Entry<String, Integer> item : sortedWords.entrySet()) {
            String result = "Word: " + item.getKey() + "; amount: " + item.getValue();
            LOGGER.info(result);
            stringToFile.append(result);
            stringToFile.append("\n");
        }

        FileUtils.writeStringToFile(new File("output.txt"), String.valueOf(stringToFile), StandardCharsets.UTF_8);
        System.out.println();

        Function<Double, Double> increasedSalary = (salaryFactor) -> {
            Integer initialRate = 1500;
            return initialRate * salaryFactor;
        };

        misha.salary(increasedSalary);
    }
}
