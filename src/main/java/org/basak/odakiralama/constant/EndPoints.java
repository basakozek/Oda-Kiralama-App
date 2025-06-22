package org.basak.odakiralama.constant;

public class EndPoints {
    public static final String VERSION = "/v1";
    public static final String API = "/api";
    public static final String DEV = "/dev";
    public static final String TEST = "/test";
    public static final String PROD = "/prod";

    public static final String ROOT = VERSION + DEV;
    //	Controller Sınıflar:
    public static final String ODA = ROOT+ "/oda";
    public static final String KIRALAMA = ROOT+ "/kiralama";
    public static final String MUSTERI = ROOT+ "/musteri";

//	Metodlar

    //ORTAK:
    public static final String SAVE = "/save";
    public static final String FINDALL = "/find-all";
    public static final String FINDBYID = "/find-by-id";
    public static final String DELETE = "/delete";
    public static final String UPDATE = "/update";
}
