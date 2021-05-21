package ru.sahlob.service;

import ru.sahlob.persistance.tour.InputTour;
import ru.sahlob.persistance.tour.Tour;

import java.util.HashSet;
import java.util.Random;

public class GenerateTestTours {


    public static Tour generateTours() {
        var tour = new Tour();
        tour.setName(generateToursName());
        tour.setSmallDescription(generateToursSmallDescription());
        tour.setCoolness(generateToursCoolness());
        tour.setEconomyPrice(generateToursPrice());
        tour.setGroupPrice(generateToursPrice());
        tour.setPremiumPrice(generateToursPrice());
        tour.setDuration(generateToursDuration());
        tour.setDescription(generateToursDescription());
        tour.setAvailableWeekDays(generateAvailableWeekDays());
        return tour;
    }

    public static String generateToursName() {
        var nameLen = new Random().nextInt(15) + 10;
        return generateSimpleRandomString(nameLen);
    }

    public static String generateToursSmallDescription() {
        var nameLen = new Random().nextInt(30) + 40;
        return generateSimpleRandomString(nameLen);
    }

    public static int generateToursCoolness() {
        return new Random().nextInt(10_000);
    }

    public static int generateToursPrice() {
        return new Random().nextInt(1_000);
    }

    public static String generateToursDuration() {
        return new Random().nextInt(9) + " часов";
    }

    public static String generateToursDescription() {
        return "<p>Одно из самых странных и загадочных мест Москвы &ndash; музей&ndash;заповедник Коломенское &ndash; предлагаем Вам посетить в компании нашего экскурсовода.<br /><br />Настоящие знатоки московской истории скажут, что Вы не видели настоящего Коломенского, если не подошли к его тайнам.<br /><br />Коломенское всегда считалось местом, где сокрыто множество тайн, зачастую не объяснимых с точки зрения обычного представления о мире. Здесь постоянно происходили мистические события, которые люди не могли принять как реальные. Однако множество свидетельств, зафиксированных документально, только подогревают интерес к этой местности.<br /><br /><strong>В ходе авторской пешеходной экскурсии по парку&ndash;музею и заповеднику Коломенское туристы смогут ознакомиться:</strong></p>\n" +
               "<ul>\n" +
               "<li>с бытом царского двора &ndash; Конюшенным, Сытным и Поваренным дворами, с тем, чем жила резиденция в летнее время, как отмечала праздники и как встречала иностранных послов;</li>\n" +
               "<li>с деятельностью русских зодчих, чьи творения стали гордостью страны, &ndash; церковью Вознесения Господня, храмом Казанской иконы Божьей Матери, колокольней святого Георгия Победоносца;</li>\n" +
               "<li>с домиком Петра I, где формировался характер будущего царя;</li>\n" +
               "<li>с образом жизни &laquo;капустных королей&raquo; &ndash; предприимчивых и трудолюбивых Коломенских крестьян;</li>\n" +
               "<li>с принципом работы водяной мельницы;</li>\n" +
               "<li>с удивительным по красоте русским деревянным зодчеством;</li>\n" +
               "<li>с местом жительства царя Алексея Михайловича &ndash; отца Петра Великого;</li>\n" +
               "<li>со знаменитым на всю Москву яблоневым садом.</li>\n" +
               "</ul>\n" +
               "<p><br /><strong>Есть в Коломенском удивительное место, называемое Голосовым оврагом. Это одно из самых таинственных и мистических мест не только в Москве, но и целой стране. Во время прогулки по Голосовому оврагу в Коломенском мы попытаемся:</strong></p>\n" +
               "<ul>\n" +
               "<li>восстановить картину битвы Георгия Победоносца со страшным Змием;</li>\n" +
               "<li>найти останки коня Георгия Победоносца;</li>\n" +
               "<li>обнаружить целебные родники;</li>\n" +
               "<li>отыскать пространственно&ndash;временной портал &ndash; говорят, он открывается по определённым дням, а таинственное зеленое свечение является проходом в него;</li>\n" +
               "<li>разыскать странных волосатых великанов, говорящих на незнакомом языке.</li>\n" +
               "</ul>\n" +
               "<p><br />По окончании экскурсии каждый турист узнает много новых и интересных фактов о Коломенском, о тайнах и загадках известного музея&ndash;заповедника, запомнив эту прогулку навсегда!</p>\n";
    }

    private static String generateSimpleRandomString(int len) {
        var newString = new StringBuilder();
        var firstLetter = "ABCDEfGHIJKLMNOPQRSTUVWXYZ";
        var letters = "abcdefghij klmnopqrstuvwxyz";
        newString.append(firstLetter.charAt(new Random().nextInt(firstLetter.length())));
        for (int i = 0; i < len - 1; i++) {
            newString.append(letters.charAt(new Random().nextInt(letters.length())));
        }
        return newString.toString();
    }

    private static HashSet<Integer> generateAvailableWeekDays() {
        new Random().nextBoolean();
        var availableWeekDays = new HashSet<Integer>();
        if (new Random().nextBoolean()) {
            availableWeekDays.add(0);
        }
        if (new Random().nextBoolean()) {
            availableWeekDays.add(1);
        }
        if (new Random().nextBoolean()) {
            availableWeekDays.add(2);
        }
        if (new Random().nextBoolean()) {
            availableWeekDays.add(3);
        }
        if (new Random().nextBoolean()) {
            availableWeekDays.add(4);
        }
        if (new Random().nextBoolean()) {
            availableWeekDays.add(5);
        }
        if (new Random().nextBoolean()) {
            availableWeekDays.add(6);
        }
        return availableWeekDays;
    }
}
