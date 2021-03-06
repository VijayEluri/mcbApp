package mcb.model;


public enum Land {

  D(""), //
  F("Frankreich"), //
  NL("Niederlande"), //
  A("Österreich"), //
  B("Belgien"), //
  CH("Schweiz"), //
  CZ("Tschechien"), //
  DK("Dänemark"), //
  E("Spanien"), //
  FIN("Finnland"), //
  FL("Liechtenstein"), //
  GB("Großbritannien"), //
  GR("Griechenland"), //
  H("Ungarn"), //
  HR("Kroatien"), //
  I("Italien"), //
  IRL("Irland"), //
  L("Luxemburg"), //
  N("Norwegen"), //
  P("Portugal"), //
  PL("Polen"), //
  S("Schweden");

  public static String landFuerKuerzel(String landText) {
    return Land.valueOf(landText).name.toUpperCase();
  }

  private String name;

  Land(String name) {
    this.name = name;
  }

}
