package com.example.app.DB;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.app.Anime;
import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {

    public DB(Context context){
        super(context,"database.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("CREATE TABLE IF NOT EXISTS UTILIZATORI(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT UNIQUE, EMAIL TEXT UNIQUE, PAROLA TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS ANIME(ID INTEGER PRIMARY KEY AUTOINCREMENT, NUME TEXT UNIQUE, DESCRIERE TEXT, NR_EPISOADE INTEGER, GEN TEXT, RATING REAL, STUDIO TEXT , IMAGINE1 INTEGER, ADAUGAT boolean, EP_CURENT Integer)");
        //db.execSQL("CREATE TABLE IF NOT EXISTS ANIME_USER(ID_USER INTEGER, ID_ANIME INTEGER, FOREIGN KEY(ID_USER) REFERENCES UTILIZATORI(ID), FOREIGN KEY(ID_ANIME) REFERENCES ANIME(ID))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS UTILIZATORI");

    }


    public boolean insert(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", 10);
        contentValues.put("NUME", "Boku no Hero Academia");
        contentValues.put("DESCRIERE", " ");
        contentValues.put("GEN", "av");
        contentValues.put("RATING", 5);
        contentValues.put("STUDIO", "Bones");
        contentValues.put("IMAGINE1", R.drawable.akatsuki);
        contentValues.put("ADAUGAT", 0);
        long rez = db.insert("ANIME",null,contentValues);
        if(rez == -1)
            return false;
        return true;
    }

    public void adauga(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        List<Anime> anime = new ArrayList<>();
        //Anime a1 = new Anime(1,"Naruto","Cu cateva momente inainte de nasterea lui Naruto Uzumaki, un demon imens, cunoscut sub numele de Kyuubi, vulpea cu noua cozi, a atacat Konohagakure, satul de frunze ascunse si l-a distrus. Pentru a pune capat ravagilor lui Kyuubi, liderul satului, al patrulea Hokage, si-a sacrificat viata si a sigilat fiara monstruoasa in nou-nascutul Naruto.",220,"a", 5,"Pierrot", R.drawable.naruto,false,0);
        //Anime a2 = new Anime(2,"Hellsing","Hellsing, o organizatie specializata in combaterea amenintarilor supranaturale, este chemata sa elimine un vampir care transforma satenii lui Cheddar in ghouli. Pentru a pune capat acestei situatii, liderul organizatiei, Sir Integra Fairbrook Wingates Hellsing, trimite cel mai formidabil bun al sau: un vampir puternic cunoscut sub numele de Alucard.",12,"a", 5,"Gonzo", R.drawable.hellsing,false,0);
        //Anime a3 = new Anime(3,"Naruto Shippuden","Continuarea Naruto",500,"a", 5,"Pierrot", R.drawable.naruto_shippuden,false,0);
        //Anime a4 = new Anime(4,"Black Butler","În era victoriană, în Europa, un băiat pierde tot ce îi este drag în urma unui complot mișelesc. Chiar înainte de a muri, încheie un contract cu un demon și oferă acestuia sufletul său în schimbul obținerii răzbunării pe cei responsabili de uciderea familiei sale. Tânărul, Ciel Phantomhive, devine moștenitorul corporației Phantomhive și totodată, îndeplinește ordinele secrete ale Reginei, alături de majordomul său demon, Sebastian Michelis.",24,"av", 5,"A-1 Pictures", R.drawable.black_butler,false,0);
        //Anime a5 = new Anime(5,"Overlord","Ultima ora a jocului de realitate virtuala Yggdrasil a venit. Cu toate acestea, Momonga, un vrajitor puternic si maestru al ghildei intunecate Ainz Ooal Gown, decide sa-si petreaca ultimele momente in joc, pe masura ce serverele incep sa se inchida. Spre surprinderea sa, in ciuda ceasului care a lovit miezul noptii, Momonga este inca pe deplin constient ca personajul sau si, in plus, personajele non-player par sa fi dezvoltat personalitati !",13,"av", 5,"MadHouse", R.drawable.overlord,false,0);
        //Anime a6 = new Anime(6,"One Piece","Gol D. Roger era cunoscut ca \"Regele Piratelor\", cea mai puternica si cea mai infama fiinta care trebuia sa navigheze pe Grand Line. Capturarea si executarea lui Roger de catre guvernul mondial a adus o schimbare in intreaga lume. Ultimele sale cuvinte inainte de moartea sa au scos la iveala existenta celei mai mari comori din lume, One Piece. A fost aceasta revelatie care a adus Marea Epoca a Piratilor, barbati care au visat sa gaseasca o singura bucata - care promite o cantitate nelimitata de bogatie si faima - si poate chiar varful gloriei si titlul de Regele Piratiilor.",0,"av", 5,"Toei Animation", R.drawable.onepiece2,false,0);
        //Anime a7 = new Anime(7,"Akatsuki no Yona","Printesa Yona traieste o viata de lux si usurinta, complet adapostita de problemele regatului aparent pasnic al lui Kouka; totusi, uciderea brusca a regelui si tradarea verisorului ei iubit Su-won plaseaza viata lui Yona în pericol mortal. Fortata sa scape numai cu Son Hak, care este atat prietenul ei din copilarie, cat si garda de corp, printesa naiva descopera curand ca Kouka nu este locul idilic pe care-l imagina să fie. Saracia, conflictul si coruptia se desfasoara neincetat, facand recuperarea tronului doar o fantezie datorita statului actual al regatului.",24,"d", 5,"Bones", R.drawable.akatsuki,false,0);
        //Anime a8 = new Anime(8,"Bleach","Ichigo Kurosaki este un elev obisnuit - pana cand familia lui este atacata de un Hollow, un spirit corupt care cauta sa devoreze sufletele umane. Apoi, el se intalneste cu un colector de suflet pe nume Rukia Kuchiki, care este ranit in timp ce protejeaza familia lui Ichigo de atacator. Pentru a-si salva familia, Ichigo accepta oferta lui Rukia de a-i lua puterile si, ca rezultat, devine un shinigami.",366,"a", 5,"Pierrot", R.drawable.bleach,false,0);
        Anime a9 = new Anime(9,"Boku no Hero Academia","Aparitia unor \"quirks\", super-puteri nou descoperite, a crescut constant de-a lungul anilor, 80% din omenire posedand diferite abilitati de la manipularea elementelor la modelarea lor. Aceasta lasa restul lumii complet neputincioase, iar Izuku Midoriya este un astfel de individ. De cand era copil, Izuku nu voia decat sa fie erou. Soarta incorecta a lui Izuku il lasa admirandu-i pe eroi pe care ii analizeaza , scriind despre ei intr-un caiet. Dar se pare ca persistenta lui a adus niste roade: Izuku intalneste eroul numarul unu si idolul sau personal, All Might. All for One este o abilitate unica care poate fi mostenita si el l-a ales pe Izuku ca succesor al lui! Dupa multe luni de antrenamente dure, Izuku se inscrie in UA High, o prestigioasa scoala renumita pentru programul de pregatire a eroilor , iar bobocii din acest an arata foarte promitatori. Cu colegii sai bizari, dar talentati si cu amenintarea amenintatoare a unei organizatii ticaloase, Izuku va afla in curand ceea ce inseamna intr-adevar sa fii erou.",13,"a", 5,"Bones", R.drawable.bokunohero,false,0);
        Anime a10 = new Anime(10,"Bungou Stray Dogs","Timp de cateva saptamani, orfelinatul lui Atsushi Nakajima a fost afectat de un tigru mistic, despre care numai el pare sa stie. Suspectat de a fi in spatele incidentelor ciudate, baiatul de 18 ani a fost dat brusc afara din orfelinat si lasat sa moara de foame, fara adapost si ratacind prin oras.",12,"a", 5,"Bones", R.drawable.bungou,false,0);
        Anime a11 = new Anime(11,"Bungou stray Dogs Sezon 2","Continuare Bungou Stray Dogs",12,"a", 5,"Bones", R.drawable.bungou_stray_dogs_2,false,0);
        Anime a12 = new Anime(12,"Cells at Work","Actiunea are loc in corpul uman, unde trilioane de celule convietuiesc. Seria se focuseaza pe aventuriile a doua celule: celula rosie AE3803, care se pierde de foarte multe ori si celula alba U-1146, care lupta impotriva virusilor care invadeaza corpul.",12,"av", 5,"Bones", R.drawable.cells,false,0);
        Anime a13 = new Anime(13,"Death Note"," Un shinigami, ca zeu al mortii, poate ucide orice persoana - cu conditia sa vada chipul victimei si sa scrie numele victimei intr-un notebook numit Death Note. Intr-o zi, Ryuk, plictisit de stilul de viata shinigami si interesat sa vada modul in care un om ar folosi carnetul mortii, arunca caietul in lumea umana.",37,"a", 5,"MadHouse", R.drawable.deathnote,false,0);
        Anime a14 = new Anime(14,"Durarara","In cartierul central Ikebukuro din Tokyo, in mijlocul numeroaselor zvonuri si avertismente ciudate de bande anonime si ocupanti periculosi, se remarca o legenda urbana deasupra restului - existenta unui calaret \"Black Rider\" fara cap, despre care se spune ca este vazut conducand o motocicleta cu jet-negru prin strazile orasului.",24,"av", 5,"Brain's Base", R.drawable.drrr,false,0);
        Anime a15 = new Anime(15,"Fairy Tail","In tara mistica a lui Fiore, magia exista ca o parte esentiala a vietii de zi cu zi. Nenumarate bresle magice se afla in centrul intregii activitati magice si servesc ca locatii pentru mage-ii de aceeasi gandire sa se grupeze si sa preia cereri de locuri de munca. Printre ei, Fairy Tail se deosebeste de restul ca un loc de forta, spirit si familie.",175,"av", 5,"A-1 Pictures", R.drawable.fairytail,false,0);
        Anime a16 = new Anime(16,"Fullmetal Alchemist","Pentru ca ceva sa fie obtinut, ceva de valoare egala trebuie pierdut",64,"a", 5,"Bones", R.drawable.fullmetal,false,0);
        Anime a17 = new Anime(17,"Saiki Kusuo","Pentru o persoana obisnuita, abilitatile psihice ar putea parea o binecuvantare; pentru Kusuo Saiki, acest lucru nu putea fi mai departe de adevar. Avand o gama larga de abilitati supranaturale, de la telepatie la viziunea cu raze X, el gaseste aceasta asa-numita binecuvantare ca fiind doar un blestem. Deoarece toate inconvenientele pe care puterile sale le provoaca in mod constant, toate obiectivele lui Kusuo devin dorinta de a avea o viata obisnuita, fara probleme - o viata in care ignoranta este fericire.",24,"av", 5,"Egg Firm", R.drawable.saikikusuo,false,0);
        Anime a18 = new Anime(18,"Servamp","Mahiru Shirota crede cu tarie ca lucrurile simple sunt cele mai bune si cele suparatoare trebuie evitate cu orice pret. Este dificil sa nu faci nimic si sa regreti mai tarziu - si aceasta ideologie l-a determinat sa ia o pisica ratacita pe drumul spre casa de la scoala. Asa cum il numeste cu blandete Kuro, putin stie ca aceasta intalnire intamplatoare va provoca o schimbare extraordinara in viata lui de zi cu zi.",12,"a", 5,"Brain's Base", R.drawable.servamp,false,0);
        Anime a19 = new Anime(19,"XxxHolic","Kimihiro Watanuki poate vedea spirite si alte creaturi supranaturale, ceea ce este o abilitate destul de deranjanta pe care o uraste. Pe drumul spre casa intr-o zi, in timp ce sufera din cauza unor spirite, el este inexplicabil obligat sa intre intr-o casa ciudata. Acolo, el se intalneste cu Yuuko, o femeie misterioasa care pretinde ca poate sa-l scape de capacitatea de a vedea si de a atrage creaturile suparatoare - pentru un pret. Ea cere sa lucreze la \"magazinul\" ei care implineste dorintele oamenilor si astfel incepe aventurile lui Watanuki printre evenimentele ciudate si minunate.",24,"a", 5,"Production I.G", R.drawable.xxxholic,false,0);
        //Anime a20= new Anime(20,"Yuri On Ice","Zdrobit de infrangerea zdrobitoare la Grand Prix Finale, Yuuri Katsuki, o data cel mai promitator patinator japonez, se intoarce la casa familiei pentru a-si evalua optiunile pentru viitor. La varsta de 23 de ani, fereastra lui Yuuri pentru succes in patinaj se inchide rapid, iar dragostea sa pentru katsudon si aptitudinea de a castiga greutate nu ajuta deloc.",12,"s", 5,"Mappa", R.drawable.yurionice,false,0);
        //anime.add(a1);anime.add(a2);anime.add(a3);anime.add(a4);anime.add(a5);
        //anime.add(a6);anime.add(a7);anime.add(a8);
        anime.add(a9);anime.add(a10);
        anime.add(a11);anime.add(a12);anime.add(a13);anime.add(a14);anime.add(a15);
        anime.add(a16);anime.add(a17);anime.add(a18);anime.add(a18);anime.add(a19);
        long rez;
        for(Anime a: anime){
            contentValues.put("ID", a.getId());
            contentValues.put("NUME", a.getName());
            contentValues.put("DESCRIERE", a.getDescription());
            contentValues.put("NR_EPISOADE", a.getNb_episode());
            contentValues.put("GEN", a.getGen());
            contentValues.put("RATING", 5);
            contentValues.put("STUDIO", a.getStudio());
            contentValues.put("IMAGINE1", a.getImg());
            contentValues.put("ADAUGAT", 0);
            contentValues.put("EP_CURENT",0);
            rez = db.insert("ANIME",null,contentValues);
        }


    }

    public void createTableAnime() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS ANIME(ID INTEGER PRIMARY KEY AUTOINCREMENT, NUME TEXT UNIQUE, DESCRIERE TEXT, NR_EPISOADE INTEGER, RATING REAL, STUDIO TEXT , IMAGINE1 INTEGER, ADAUGAT boolean, NR_EP_CURENTE Integer)");
    }



    public void update1() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ANIME ", null);
        if (c.moveToFirst()) {

            db.execSQL("UPDATE ANIME SET nr_episoade= "+ R.drawable.bokunohero +" WHERE ID in (10)" );
        }
        c.close();
    }



    public void setAdaugat(String nume){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ANIME WHERE NUME ='"+nume+"'", null);

        if (c.moveToFirst()) {

            db.execSQL("UPDATE ANIME SET adaugat = 1 WHERE NUME like '"+nume+"'" );
        }
        c.close();
    }
    public void setNeAdaugat(String nume){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ANIME WHERE NUME ='"+nume+"'", null);

        if (c.moveToFirst()) {

            db.execSQL("UPDATE ANIME SET adaugat = 0 WHERE NUME ='"+nume+"'" );
        }
        c.close();
    }

    public void setRating(float f, String nume, float rat){
        f = (f+rat)/2;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ANIME WHERE NUME ='"+nume+"'", null);

        if (c.moveToFirst()) {

            db.execSQL("UPDATE ANIME SET rating ="+f+" WHERE NUME ='"+nume+"'" );
        }
        c.close();
    }

    public void setEp( String nume, int ep){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ANIME ", null);

        if (c.moveToFirst()) {

            db.execSQL("UPDATE ANIME SET EP_CURENT ="+ep+" WHERE NUME ='"+nume+"'" );
        }
        c.close();
    }

    public int getNrAnime(){
        SQLiteDatabase db = this.getReadableDatabase();
        int nr = 0;
        Cursor c = db.rawQuery("SELECT * FROM ANIME WHERE ADAUGAT = 1", null);

        if (c.moveToFirst()) {

            nr = c.getCount();
        }
        c.close();
        return nr;
    }
    public List<Integer> getNrEp(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Integer> l = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM ANIME WHERE ADAUGAT = 1", null);

        while (c.moveToNext()) {
            int k = c.getInt(3);
            System.out.println(k);
            l.add(k);
        }

        c.close();
        return l;
    }

    public List<String> getNume(){
        List<String> rez = new ArrayList<>();
        //rez.ad("\n");

        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor a = DB.rawQuery("SELECT * FROM ANIME GROUP BY NUME", null);
        while(a.moveToNext()){

            String nume = a.getString(1);
            rez.add(nume );
        }
        a.close();
        return rez;

    }



    public List<Anime> getGenuri(String gen){
        List<Anime> anime =new ArrayList<>();
        SQLiteDatabase DB = this.getReadableDatabase();
        String sql = "SELECT * FROM ANIME WHERE GEN ='" + gen +"'";
        Cursor a = DB.rawQuery(sql, null);
        while(a.moveToNext()){
            Anime an;
            int id = a.getInt(0);
            String nume = a.getString(1);
            String descriere = a.getString(2);
            int nr = a.getInt(3);
            String g = a.getString(4);
            Float r = a.getFloat(5);
            String s = a.getString(6);
            int img = a.getInt(8);
            int ad = a.getInt(9);
            int ep = a.getInt(10);
            if(ad == 0) {
                an = new Anime(id, nume, descriere, nr, g, r, s, img, false,ep);
            }
            else{
                an = new Anime(id, nume, descriere, nr, g, r, s, img, true,ep);
            }
            anime.add(an );


        }
        a.close();
        return anime;
    }

    public List<Anime> getAnime(){
        List<Anime> anime =new ArrayList<>();
        SQLiteDatabase DB = this.getReadableDatabase();
        String sql = "SELECT * FROM ANIME ORDER BY NUME";
        Cursor a = DB.rawQuery(sql, null);
        while(a.moveToNext()){
            Anime an;
            int id = a.getInt(0);
            String nume = a.getString(1);
            String descriere = a.getString(2);
            int nr = a.getInt(3);
            String g = a.getString(4);
            Float r = a.getFloat(5);
            String s = a.getString(6);
            int img = a.getInt(8);
            int ad = a.getInt(9);
            int ep = a.getInt(10);
            if(ad == 0) {
                an = new Anime(id, nume, descriere, nr, g, r, s, img, false,ep);
            }
            else{
                an = new Anime(id, nume, descriere, nr, g, r, s, img, true,ep);
            }
            anime.add(an );


        }
        a.close();
        return anime;
    }

    public List<Anime> getCautareAnime(String c){
        List<Anime> anime =new ArrayList<>();
        SQLiteDatabase DB = this.getReadableDatabase();
        String sql = "SELECT * FROM ANIME WHERE NUME LIKE '"+ c +"%' ORDER BY NUME";
        Cursor a = DB.rawQuery(sql, null);
        while(a.moveToNext()){
            Anime an;
            int id = a.getInt(0);
            String nume = a.getString(1);
            String descriere = a.getString(2);
            int nr = a.getInt(3);
            String g = a.getString(4);
            Float r = a.getFloat(5);
            String s = a.getString(6);
            int img = a.getInt(8);
            int ad = a.getInt(9);
            int ep = a.getInt(10);
            if(ad == 0) {
                an = new Anime(id, nume, descriere, nr, g, r, s, img, false,ep);
            }
            else{
                an = new Anime(id, nume, descriere, nr, g, r, s, img, true,ep);
            }
            anime.add(an );


        }
        a.close();
        return anime;
    }


    public List<Anime> getListaAnime(){
        List<Anime> anime =new ArrayList<>();
        SQLiteDatabase DB = this.getReadableDatabase();
        String sql = "SELECT * FROM ANIME WHERE ADAUGAT = 1 ORDER BY NUME";
        Cursor a = DB.rawQuery(sql, null);
        while(a.moveToNext()){
            Anime an;
            int id = a.getInt(0);
            String nume = a.getString(1);
            String descriere = a.getString(2);
            int nr = a.getInt(3);
            String g = a.getString(4);
            Float r = a.getFloat(5);
            String s = a.getString(6);
            int img = a.getInt(8);
            int ad = a.getInt(9);
            int ep = a.getInt(10);
            if(ad == 0) {
                an = new Anime(id, nume, descriere, nr, g, r, s, img, false,ep);
            }
            else{
                an = new Anime(id, nume, descriere, nr, g, r, s, img, true,ep);
            }
            anime.add(an );


        }
        a.close();
        return anime;
    }

    public Anime getAnimeSpecific(int pos) {
        Anime an = null;
        SQLiteDatabase DB = this.getReadableDatabase();
        String sql = "SELECT * FROM ANIME WHERE ID = " + pos;
        Cursor a = DB.rawQuery(sql, null);
        while (a.moveToNext()) {

            int id = a.getInt(0);
            String nume = a.getString(1);
            String descriere = a.getString(2);
            int nr = a.getInt(3);
            String g = a.getString(4);
            Float r = a.getFloat(5);
            String s = a.getString(6);
            int img = a.getInt(8);
            int ad = a.getInt(9);
            int ep = a.getInt(10);
            if (g.equals("a")) {
                g = "actiune";
            } else {
                if (g.equals("av")) {
                    g = "aventura";
                } else {
                    if (g.equals("c")) {
                        g = "comedie";
                    } else {
                        if (g.equals("d")) {
                            g = "dragoste";
                        } else {
                            if (g.equals("s")) {
                                g = "sport";
                            }

                        }}}}
                        if (ad == 0) {
                            an = new Anime(id, nume, descriere, nr, g, r, s, img, false, ep);
                        } else {
                            an = new Anime(id, nume, descriere, nr, g, r, s, img, true, ep);
                        }


                    }
                    a.close();
                    return an;
                }


                public int getId (String nume){
                    int i = 0;
                    SQLiteDatabase DB = this.getReadableDatabase();
                    String sql = "SELECT ID FROM ANIME WHERE NUME ='" + nume + "'";
                    Cursor a = DB.rawQuery(sql, null);
                    while (a.moveToNext()) {
                        i = a.getInt(0);
                    }
                    a.close();
                    return i;
                }



}
