import factory._01simplesingleton.Supa;
import factory._01simplesingleton.SupaSimpleFactorySingleton;
import factory._01simplesingleton.TipSupa;

void main() {
    SupaSimpleFactorySingleton supaSimpleFactorySingleton = SupaSimpleFactorySingleton.getInstanta();
    Supa supaLegume = supaSimpleFactorySingleton.getSupa(TipSupa.LEGUME, "Supa de legume");
    Supa supaCiuperci = supaSimpleFactorySingleton.getSupa(TipSupa.CIUPERCI, "Supa de ciuperci");
    Supa supaVita = supaSimpleFactorySingleton.getSupa(TipSupa.VITA, "Supa de vita", 120.0);

    List<Supa> supe = Arrays.asList(supaLegume, supaCiuperci, supaVita);
    supe.forEach(Supa::afiseazaDetalii);
}