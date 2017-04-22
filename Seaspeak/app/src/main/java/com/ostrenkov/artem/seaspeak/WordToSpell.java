package com.ostrenkov.artem.seaspeak;

public class WordToSpell {

    private  String[] WordsArr = {"ALPHA","BRAVO","CHARLE","DELTA","ECHO","FOXTROT","GOLF","HOTEL","INDIA","JULIET","KILO","LIMA","MIKE","NOVEMBER","OSCAR","PAPA","QUEBEC","ROMEO","SIERRA","TANGO","UNIFORM","VICTOR","WHISKEY","X-RAY","YANKEE","ZULU"," "};
    private  String CharsArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private  int iLong = 0;
//    private String[] WordsShort = {" deg "," min "," sec ","N","S","E ","W "," degree "," minutes "," seconds ","North","South","East ","West " };
    private String[] WordsNumbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    private String[] WordsShort = {"° ","' ","'' ","N","S","E ","W "," degree "," minutes "," seconds ","North","South","East ","West " };


    public void SpellLong(Boolean sh){
        if (sh) { iLong = 1;}
        else  iLong = 0;
    }

    private String SpellNumbers(int num, Boolean londeg){

        //  String sNume = Integer.toString(num);
        String sRes = "";


        if (num > 360) {return "MISTAKE";}

        int numbr = (int)Math.floor(num/100);
        int numbrD = (int)Math.floor((num - numbr*100)/10);
        int numbrN = (int)Math.floor((num - numbr*100 - numbrD*10));



        if (londeg) {
            sRes =   WordsNumbers[numbr]+ "-" + WordsNumbers[numbrD] + "-" + WordsNumbers[numbrN] ;

        } else   sRes =  WordsNumbers[numbrD] + "-" + WordsNumbers[numbrN] ;

        //sRes =  num +" ?  " + numbr+ "-" + numbrD + "-" +numbrN ;

        return sRes;

    }

    public String SpellNumbers(String number){

        //  String sNume = Integer.toString(num);
        String sRes = "";

        for (int i = 0 ;i < number.length();i++) {
            char c = number.charAt(i);
            switch (number.charAt(i)){

                case '0':
                    sRes = sRes + "-"+WordsNumbers[0];
                    break;
                case '1':
                    sRes = sRes + "-"+WordsNumbers[1];
                    break;
                case '2':
                    sRes = sRes + "-"+WordsNumbers[2];
                    break;
                case '3':
                    sRes = sRes + "-"+WordsNumbers[3];
                    break;
                case '4':
                    sRes = sRes + "-"+WordsNumbers[4];
                    break;
                case '5':
                    sRes = sRes + "-"+WordsNumbers[5];
                    break;
                case '6':
                    sRes = sRes + "-"+WordsNumbers[6];
                    break;
                case '7':
                    sRes = sRes + "-"+WordsNumbers[7];
                    break;
                case '8':
                    sRes = sRes + "-"+WordsNumbers[8];
                    break;
                case '9':
                    sRes = sRes + "-"+WordsNumbers[9];
                    break;
                case ',':
                    sRes = sRes + "-"+ "Decimal";
                    break;
                case '.':
                    sRes = sRes + "-"+ "Decimal";
                    break;
                case ':':
                    sRes = sRes + " ";
                    break;


                default:
                    sRes = sRes + number.charAt(i);
                    break;
            }

        }
        sRes = sRes.substring(1);

        return sRes;

    }

    public String SpellLine(String line){

        String newline = "";
        String workline = line.toUpperCase();
        for (int i = 0; i < line.length();i++ ) {
            int k = CharsArr.indexOf(workline.charAt(i));
            if (k == -1) newline = newline + " ";
            // заменил звездочку на пробел
            else newline = newline + " "+ WordsArr[k];
        }
        return newline;
    }

    public String LocationToCoordinates(double lat, double lon){
        String sResult = "empty";

        if (iLong == 0) {
            if (lat > 0) {
                sResult = NumberToCoordinates(lat) + WordsShort[3 + 7 * iLong]+ ",";
            } else {
                sResult = NumberToCoordinates(lat * (-1)) + WordsShort[4 + 7 * iLong]+ ",";
            }

            if (lon > 0) {
                sResult = sResult + " " + NumberToCoordinates(lon) + WordsShort[5 + 7 * iLong];
            } else {
                sResult = sResult + " " + NumberToCoordinates(lon * (-1)) + WordsShort[6 + 7 * iLong];
            }

        } else
        {
            if (lat > 0) {
                sResult = SpellNumberToCoordinates(lat, false) + WordsShort[3 + 7 * iLong]+ ",";
            } else {
                sResult = SpellNumberToCoordinates(lat * (-1), false) + WordsShort[4 + 7 * iLong]+ ",";
            }

            if (lon > 0) {
                sResult = sResult + " " + SpellNumberToCoordinates(lon, true) + WordsShort[5 + 7 * iLong];
            } else {
                sResult = sResult + " " + SpellNumberToCoordinates(lon * (-1), true) + WordsShort[6 + 7 * iLong];
            }


        }
        return sResult;
    }

    private String NumberToCoordinates(double coordinates){
        double grad = Math.floor(coordinates);
        double sek =  Math.floor((coordinates - Math.floor(coordinates))*3600);
        double minutes = Math.floor(sek/60);
        sek = sek - minutes*60;
        int grad1 = (int)grad;
        int sek1 = (int)sek;
        int minutes1 = (int)minutes;

        return grad1 + WordsShort[0+ 7*iLong]+ minutes1+ WordsShort[1+ 7*iLong]+ sek1 + WordsShort[2+ 7*iLong];
    }


    private String SpellNumberToCoordinates(double coordinates, Boolean lon){
        double grad = Math.floor(coordinates);
        double sek =  Math.floor((coordinates - Math.floor(coordinates))*3600);
        double minutes = Math.floor(sek/60);
        sek = sek - minutes*60;
        int grad1 = (int)grad;
        int sek1 = (int)sek;
        int minutes1 = (int)minutes;

        String sGrad = "";
        String sMin = "";
        String sSek  = "";

       if (iLong == 0) {
            sGrad = Integer.toString(grad1);
            sMin = Integer.toString(minutes1);
            sSek = Integer.toString(sek1);
        } else {
            sGrad = SpellNumbers(grad1, lon);
            sMin = SpellNumbers(minutes1, false);
            sSek = SpellNumbers(sek1, false);
        }

        return sGrad + WordsShort[0+ 7*iLong]+ sMin+ WordsShort[1+ 7*iLong]+ sSek + WordsShort[2+ 7*iLong];
    }

}

