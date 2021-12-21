package ru.sahlob.service;

import ru.sahlob.persistance.tour.Tour;
import ru.sahlob.persistance.tour.VisitedPlace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        tour.setBeginningTourHour(generateBeginningTourTimeHour());
        tour.setBeginningTourMinutes(generateBeginningTourTimeMinutes());
        tour.setVisitedPlaces(generateVisitedPlaces());
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

    public static Integer generateToursDuration() {
        return new Random().nextInt(9);
    }

    public static int generateBeginningTourTimeHour() {
        return new Random().nextInt(20);
    }

    public static int generateBeginningTourTimeMinutes() {
        return new Random().nextInt(59);
    }

    public static String generateToursDescription() {
        return "<header class=\"entry-header\">\n"
                + "<p><strong>Home</strong></p>\n"
                + "<p>Snipe eel Sundaland noodlefish elasmobranch parasitic catfish. Walleye mud cat kissing gourami armorhead catfish halfmoon lizardfish archerfish mrigal Oregon chub northern anchovy bonytongue. Mozambique tilapia jack tommy ruff; southern smelt bangus Japanese eel. Snoek salamanderfish golden dojo Redfin perch clown loach; bristlenose catfish, mudminnow loach minnow; staghorn sculpin. Dartfish alligatorfish pomfret bullhead yellow-and-black triplefin barbeled houndshark poacher dragonet spiny-back ground shark yellow-and-black triplefin Atlantic salmon. Electric knifefish featherfin knifefish blue eye Hammerjaw orange roughy clownfish peacock flounder. Rough sculpin: African lungfish basslet halibut pencil catfish; chum salmon cod icefish. Tiger barb cisco tiger shark parrotfish mooneye nurse shark.</p>\n"
                + "<p>Kanyu spinefoot; largenose fish; whiting rocket danio spinyfin mako shark Blobfish crestfish staghorn sculpin wormfish whitefish tiger barb. Longnose lancetfish houndshark Red salmon whale shark warbonnet.</p>\n"
                + "<p>&nbsp;</p>\n"
                + "<p><strong>New Home</strong></p>\n"
                + "<p>Platy Australian grayling turkeyfish, zebra turkeyfish. Cuchia, forehead brooder bullhead; staghorn sculpin, algae eater wels catfish tarpon Billfish sand goby. Filefish bobtail snipe eel clown loach bat ray freshwater eel monkfish luderick torrent catfish jewel tetra, African glass catfish Lost River sucker ribbon eel. Yellow tang lizardfish, hake humuhumunukunukuapua&amp;rsquo;a Blind shark oldwife Black swallower! Rio Grande perch, airbreathing catfish, smalltooth sawfish sawfish, ziege; harelip sucker ladyfish New World rivuline, &amp;laquo;char tarpon frogmouth catfish stickleback cow shark.&amp;raquo;</p>\n"
                + "<p>&nbsp;</p>\n"
                + "<ul>\n"
                + "<li>first poin ray roach blobfish mustache triggerfish pumpkinseed eelpout ling cod LostRiver sucker horn shark</li>\n"
                + "<li>fish. Titan triggerfish barreleye Rasbora; crappie bull shark thresher shark grunion platy barramundi. Tripod fish, boga pearleye Peter&amp;rsquo;s elephantnose fish Indian mul Mexican golden trout. Halfmoon cherry salmon, seatrout river shark filefish sabert</li>\n"
                + "<li>starry flounder cardinalfish scorpionfish. Titan triggerfish barreleye Rasbora; crappie bull shark thresher shark grunion platy barramundi. Tripod fish, boga pearleye Peter&amp;rsquo;s elephantnose fish Indian mul Mexican golden trout. Halfmoon cherry salmon, seatrout river shark filefish sabertooth. Pilot fish antenna codlet, anemonefish popeye catafula kappy African lungfish. Barbelless catfish, sea toad eel-goby mud</li>\n"
                + "<li>qwerqeqer eriwvljrjkwref</li>\n"
                + "<li>wefkljqwefnv;kj dfqewlkjqwe efoqiweufklj sdvaev;klj weoqpiuwef</li>\n"
                + "</ul>\n"
                + "<p>Ray roach Blobfish mustache triggerfish, pumpkinseed eelpout ling cod Lost River sucker horn shark&amp;mdash;African lungfish. Tench, skipping goby gopher rockfish, gianttail soldierfish wallago. Manta Ray kissing gourami, mustard eel killifish redlip blenny sheepshead killifish duckbill eel Pacific cod dottyback velvetfish danio! Scaleless black dragonfish shark; Blind shark. Wobbegong false brotula, yellowfin surgeonfish cusk-eel hamlet blue shark; sablefish plaice requiem shark tailor mustard eel.</p>\n"
                + "<p>White marlin pineconefish northern sea robin, naked-back knifefish longnose sucker paperbone barbeled houndshark; sculpin, gulper eel; footballfish, mola pompano Redfin perch, popeye catafula. Bigscale pomfret sandroller snook frilled shark gopher rockfish&amp;mdash;round stingray, cowfish steelhead archerfish grenadier, temperate ocean-bass. Combtail gourami zebra pleco mola mola sunfish vendace northern lampfish zebra pleco; spiderfish Ratfish, sheepshead Atlantic saury Hammerjaw pricklefish. Temperate ocean-bass creek chub: rough pomfret: bocaccio starry flounder cardinalfish scorpionfish. Titan triggerfish barreleye Rasbora; crappie bull shark thresher shark grunion platy barramundi. Tripod fish, boga pearleye Peter&amp;rsquo;s elephantnose fish Indian mul Mexican golden trout. Halfmoon cherry salmon, seatrout river shark filefish sabertooth. Pilot fish antenna codlet, anemonefish popeye catafula kappy African lungfish. Barbelless catfish, sea toad eel-goby mudminnow gouramie livebearer Rabbitfish alligatorfish crocodile shark, Lost River sucker. Pikehead velvet catfish dab Atlantic eel coelacanth tui chub carpsucker warmouth!</p>\n"
                + "<p><br />Does your lorem ipsum text long for something a&amp;nbsp;little fishier? Give our generator a&amp;nbsp;try... it&amp;rsquo;s fishy!</p>\n"
                + "</header>";
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

    private static List<VisitedPlace> generateVisitedPlaces() {
        var visitedPlaces = new ArrayList<VisitedPlace>();
        var countPlaces = new Random().nextInt(7) + 3;
        for (int i = 0; i < countPlaces; i++) {
            var visitPlace = new VisitedPlace();
            visitPlace.setName(generateSimpleRandomString(new Random().nextInt(30) + 8));
            visitPlace.setDescription(generateSimpleRandomString(new Random().nextInt(30) + 40));
            visitPlace.setDuration(new Random().nextInt(3));
            visitedPlaces.add(visitPlace);
        }
        return visitedPlaces;
    }
}
