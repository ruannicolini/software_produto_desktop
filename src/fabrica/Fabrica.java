package fabrica;

import negocio.Produto;

/**
 *
 * @author Luiz
 */
public class Fabrica implements FabricaAbstrata {

    @Override
    public Produto criarProduto() {
        return new Produto();
    }
    
}
