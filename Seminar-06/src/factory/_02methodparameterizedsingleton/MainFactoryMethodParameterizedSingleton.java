import factory._02methodparameterizedsingleton.*;

void main() {
    FelMancareFactoryMethodParameterized felMancareSupaFactoryMethodParameterized = FelMancareSupaFactoryMethodParameterized.getInstanta();
    FelMancare supaLegume = felMancareSupaFactoryMethodParameterized.getFelMancare(TipSupa.LEGUME, "Supa de legume");
    FelMancare supaCiuperci = felMancareSupaFactoryMethodParameterized.getFelMancare(TipSupa.CIUPERCI, "Supa de ciuperci");
    FelMancare supaVita = felMancareSupaFactoryMethodParameterized.getFelMancare(TipSupa.VITA, "Supa de vita", 120.0);

    FelMancareFactoryMethodParameterized felMancareDesertFactoryMethodParameterized = FelMancareDesertFactoryMethodParameterized.getInstanta();
    FelMancare papanasi = felMancareDesertFactoryMethodParameterized.getFelMancare(TipDesert.PAPANASI, "Papanasi");
    FelMancare clatite = felMancareDesertFactoryMethodParameterized.getFelMancare(TipDesert.CLATITE, "Clatite");
    FelMancare cheesecake = felMancareDesertFactoryMethodParameterized.getFelMancare(TipDesert.CHEESECAKE, "Cheesecake", 200.0);

    List<FelMancare> feluriMancare = Arrays.asList(supaLegume, supaCiuperci, supaVita, papanasi, clatite, cheesecake);
    feluriMancare.forEach(FelMancare::afiseazaDetalii);
}