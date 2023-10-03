import br.edu.umfg.estrategia.*;


public class Main {
    public static void main(String[] args) {
        try {

            Produto produto1 = new Produto("0001",
                    "Cola cola 350ml", 3.59);
            Produto produto2 = new Produto("0002",
                    "X-salada", 15.99);
            Carrinho carrinho = new Carrinho();

            carrinho.adicionarProduto(produto1);
            carrinho.adicionarProduto(produto2);

            String formaDePagamento = "CC";
            //String formaDePagamento = "CD";
            //String formaDePagamento = "D";

            if (formaDePagamento.equalsIgnoreCase("CC")) {
                MeioPagamentoCieloCreditoEstrategia meioPagamentoCieloCreditoEstrategia = new MeioPagamentoCieloCreditoEstrategia("5517976355356417", "29818375084", "666", "04/25", "C");
                meioPagamentoCieloCreditoEstrategia.validarDadosCredito();
                carrinho.pagar(meioPagamentoCieloCreditoEstrategia);

            } else if (formaDePagamento.equalsIgnoreCase("CD")) {
                MeioPagamentoCieloDebitoEstrategia meioPagamentoCieloDebitoEstrategia = new MeioPagamentoCieloDebitoEstrategia("5517976355356417", "29818375084", "666", "04/25", "C");
                meioPagamentoCieloDebitoEstrategia.validarDadosCredito();
                carrinho.pagar(meioPagamentoCieloDebitoEstrategia);

            } else if (formaDePagamento.equalsIgnoreCase("D")) {
                carrinho.pagar(new MeioPagamentoDinheiroEstrategia());

            }

        } catch (Exception ex){
            System.out.println("Erro tipo: " + ex);
        }
    }
}