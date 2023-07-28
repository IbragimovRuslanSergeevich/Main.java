public enum RomeOtvet {
    I("1", "I"), II("2", "II"), III("3", "III"),
    IV("4", "IV"), V("5", "V"),
    VI("6", "VI"), VII("7", "VII"),
    VIII("8", "VIII"), IX("9", "IX"),
    X("10", "X"), XX("20", "XX"),
    XXX("30", "XXX"), XL("40", "XL"),
    L("50", "L"), LX("60", "LX"),
    LXX("70", "LXX"), LXXX("80", "LXXX"),
    XC("90", "XC"), C("100", "C");

    private String znachenieOtvet;
    private String znachenieStrokiOtvet;

    RomeOtvet(String znachenieOtvet, String znachenieStrokiOtvet) {
        this.znachenieOtvet = znachenieOtvet;
        this.znachenieStrokiOtvet = znachenieStrokiOtvet;
    }

    public String  getZnachenieOtvet() {
        return znachenieOtvet;
    }

    public String getZnachenieStrokiOtvet() {
        return znachenieStrokiOtvet;
    }
}
