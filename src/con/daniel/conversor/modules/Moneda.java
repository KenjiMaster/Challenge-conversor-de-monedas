package con.daniel.conversor.modules;

import java.util.Map;

public record Moneda(Map<String, Double> conversion_rates) {
}
