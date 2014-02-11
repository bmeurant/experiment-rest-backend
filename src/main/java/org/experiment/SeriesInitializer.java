package org.experiment;

import javax.inject.Inject;
import javax.inject.Named;

import org.experiment.model.Album;
import org.experiment.model.Series;
import org.experiment.repository.AlbumRepository;
import org.experiment.repository.SeriesRepository;
import org.resthub.common.util.PostInitialize;

import java.util.Calendar;

@Named("seriesInitializer")
public class SeriesInitializer {

    @Inject
    @Named("seriesRepository")
    private SeriesRepository seriesRepository;

    @Inject
    @Named("albumRepository")
    private AlbumRepository albumRepository;

    @PostInitialize
    public void init() {
        Series series = new Series("BlackSad");
        series.setScriptwriter("Juan Diaz Canales");
        series.setIllustrator("Juanjo Guarnido");
        series.setPublisher("Dargaud");
        series.setSummary("Private investigator John Blacksad is up to his feline ears in mystery, digging into the backstories behind murders, child abductions, and nuclear secrets. Guarnido's sumptuously painted pages and rich cinematic style bring the world of 1950s America to vibrant life, with Canales weaving in fascinating tales of conspiracy, racial tension, and the \"red scare\" Communist witch hunts of the time. Guarnido reinvents anthropomorphism in these pages, and industry colleagues no less than Will Eisner, Jim Steranko, and Tim Sale are fans! Whether John Blacksad is falling for dangerous women or getting beaten to within an inch of his life, his stories are, simply put, unforgettable");
        series.setCoverName("blacksad.jpg");
        seriesRepository.save(series);

        Album album = new Album("Somewhere Within the Shadows");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.NOVEMBER, 1);
        album.setPublicationDate(cal.getTime());
        album.setNumber(1);
        album.setCoverName("blacksad-1.jpg");
        album.setSeries(series);
        albumRepository.save(album);

        album = new Album("Arctic-Nation");
        cal.set(2003, Calendar.MARCH, 1);
        album.setPublicationDate(cal.getTime());
        album.setNumber(2);
        album.setCoverName("blacksad-2.jpg");
        album.setSeries(series);
        albumRepository.save(album);

        album = new Album("Red Soul");
        cal.set(2005, Calendar.NOVEMBER, 1);
        album.setPublicationDate(cal.getTime());
        album.setNumber(3);
        album.setCoverName("blacksad-3.jpg");
        album.setSeries(series);
        albumRepository.save(album);

        album = new Album("A Silent Hell");
        cal.set(2010, Calendar.SEPTEMBER, 1);
        album.setPublicationDate(cal.getTime());
        album.setNumber(4);
        album.setCoverName("blacksad-4.jpg");
        album.setSeries(series);
        albumRepository.save(album);

        album = new Album("Amarillo");
        cal.set(2013, Calendar.NOVEMBER, 1);
        album.setPublicationDate(cal.getTime());
        album.setNumber(5);
        album.setCoverName("blacksad-5.jpg");
        album.setSeries(series);
        albumRepository.save(album);

        series = new Series("The Killer");
        series.setScriptwriter("Luc Jacamon");
        series.setIllustrator("Matz");
        series.setPublisher("Casterman");
        series.setSummary("A man solitary and cold, methodical and unencumbered by scruples or regrets, the killer waits in the shadows, watching for his next target. And yet the longer he waits, the more he thinks he's losing his mind, if not his cool. A brutal, bloody and stylish noir story of a professional assassin lost in a world without a moral compass, this is a case study of a man alone, armed to the teeth and slowly losing his mind.");
        series.setCoverName("the-killer.jpg");
        seriesRepository.save(series);

        series = new Series("The Nikopol Trilogy");
        series.setScriptwriter("Enki Bilal");
        series.setIllustrator("Enki Bilal");
        series.setPublisher("Les Humanoïdes Associés");
        series.setCoverName("nikopol.png");
        seriesRepository.save(series);

        series = new Series("Akira");
        series.setScriptwriter("Katsuhiro Ôtomo");
        series.setIllustrator("Katsuhiro Ôtomo");
        series.setPublisher("Epic Comics");
        series.setSummary("In the year 2038. A police state, scheming politicians, religions sects, revolutionaries and a secret scientific project all combine to produce an explosive mixture in Neo-Tokyo. The rival groups all have their eyes on one prize: control of Akira, a boy of such destructive psychic ability that he has been held in cryo-stasis for over 30 years. A coup is planned, but there is a wild card in play: the psychic Tetsuo, an impetuous young biker who releases Akira and so forces all of the groups to make their move.");
        series.setCoverName("akira.jpg");
        seriesRepository.save(series);

        series = new Series("Calvin and Hobbes");
        series.setScriptwriter("Bill Watterson");
        series.setIllustrator("Bill Watterson");
        series.setPublisher("Andrews McMeel Publishing");
        series.setSummary("Calvin and Hobbes is unquestionably one of the most popular comic strips of all time. The imaginative world of a boy and his real-only-to-him tiger was first syndicated in 1985 and appeared in more than 2,400 newspapers when Bill Watterson retired on January 1, 1996. The entire body of Calvin and Hobbes cartoons published in a truly noteworthy tribute to this singular cartoon in The Complete Calvin and Hobbes. Composed of three hardcover, four-color volumes in a sturdy slipcase, this New York Times best-selling edition includes all Calvin and Hobbes cartoons that ever appeared in syndication. This is the treasure that all Calvin and Hobbes fans seek.");
        series.setCoverName("calvin-hobbes.png");
        seriesRepository.save(series);

        series = new Series("From Hell");
        series.setScriptwriter("Alan Moore");
        series.setIllustrator("Eddie Campbell");
        series.setPublisher("Eddie Campbell Comics");
        series.setSummary("FROM HELL is the story of Jack the Ripper, perhaps the most infamous man in the annals of murder. Detailing the events leading up to the Whitechapel killings and the cover-up that followed, FROM HELL is a meditation on the mind of a madman whose savagery and violence gave birth to the 20th century. The serialized story, presented in its entirety in this volume, has garnered widespread attention from critics and scholars. Often regarded as one of the most significant graphic novels ever published, FROM HELL combines meticulous research with educated speculation, resulting in a masterpiece of historical fiction both compelling and terrifying. This new edition, which has been completely re-mastered, is certainly the finest edition of the book produced to date.");
        series.setCoverName("from-hell.jpg");
        seriesRepository.save(series);

        series = new Series("Sin City");
        series.setScriptwriter("Frank Miller");
        series.setIllustrator("Frank Miller");
        series.setPublisher("Dark Horse");
        series.setSummary("Sin City is the place - tough as leather and dry as tinder. Love is the fuel, and the now-infamous character Marv has the match ... not to mention a \"condition.\" He's gunning after Goldie's killer, so it's time to watch this town burn!");
        series.setCoverName("sin-city.jpg");
        seriesRepository.save(series);

    }
}
