package com.cgi.utils;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Enum {

    public enum TipoTelefone {
        CELULAR("Celular"),
        COMERCIAL("Comercial"),
        RESIDENCIAL("Residencial");

        public String texto;

        TipoTelefone(String tipoTelefone) {
            texto = tipoTelefone;
        }
    }

    public enum Genero {
        MASCULINO("Masculino"),
        FEMININO("Feminino"),
        OUTRO("Outro"),
        NAO_INFORMAR("Não Informar");

        public String texto;

        Genero(String genero) {
            texto = genero;
        }
    }

    public enum EstadoCivil {
        SOLTEIRO("Solteiro"),
        CASADO("Casado"),
        VIUVO("Viúvo"),
        SEPARADO_JUDICIALMENTE("Separado Judicialmente"),
        DIVORCIADO("Divorciado");

        public String texto;

        EstadoCivil(String estadoCivil) {
            texto = estadoCivil;
        }
    }

    public enum TipoConta {
        CORRENTE("Conta Corrente"),
        POUPANCA("Conta Poupança"),
        INVESTIMENTO("Conta de Investimento");

        public String texto;

        TipoConta(String tipoConta) {
            texto = tipoConta;
        }
    }

    public enum TipoTransacao {
        DEPOSITO("Depósito"),
        RETIRADA("Retirada"),
        TRANSFERENCIA("Transferência"),
        PAGAMENTO_CONTA("Pagamento de Conta"),
        PAGAMENTO_CARTAO_CREDITO("Pagamento de Cartão de Crédito"),
        CHEQUE("Cheque"),
        CONSULTA_SALDO("Consulta de Saldo"),
        CONSULTA_EXTRATO("Consulta de Extrato"),
        APLICACAO_INVESTIMENTO("Aplicação de Investimento"),
        SOLICITACAO_EMPRESTIMO("Solicitação de Empréstimo");

        public String texto;

        TipoTransacao(String tipoTransacao) {
            texto = tipoTransacao;
        }
    }

    public enum TipoInvestimento {
        URUBU_DO_PIX("Urubu do pix");

        public String texto;

        TipoInvestimento(String tipoInvestimento) {
            texto = tipoInvestimento;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum Animais {
        AVESTRUZ("Avestruz", "https://i.pinimg.com/originals/8a/e8/e7/8ae8e7459e6b38b372dff0e81b44c68f.jpg"),
        AGUIA("Águia", "https://pngimg.com/uploads/eagle/eagle_PNG1211.png"),
        BURRO("Burro",
                "https://www.pngall.com/wp-content/uploads/2/Donkey-PNG-HD-Image.png"),
        BORBOLETA("Borboleta",
                "https://www.pngmart.com/files/15/Blue-Butterfly-PNG-Photos.png"),
        CACHORRO("Cachorro", "https://www.pngplay.com/wp-content/uploads/6/Puppy-Dog-Transparent-PNG.png"),
        CABRA("Cabra",
                "https://image.freepik.com/free-photo/goat-standing-up-isolated-white-background_191971-8608.jpg"),
        CARNEIRO("Carneiro",
                "https://freepngimg.com/thumb/sheep/7-sheep-png-image.png"),
        CAMELO("Camelo",
                "https://purepng.com/public/uploads/large/camel-clip-art-zns.png"),
        COBRA("Cobra", "https://pngimg.com/uploads/snake/snake_PNG4072.png"),

        COELHO("Coelho",
                "https://purepng.com/public/uploads/large/91508357962gfek71olknjv3qp5jmvaedmpg2ila0n3cf1npab74efaaetzc2lxghjb3mogntvmlc7aouuhfmgpmb9l2xsct0y3dibq3tmomb9v.png"),
        CAVALO("Cavalo", "https://freepngimg.com/download/horse/2-2-horse-png-8.png"),

        ELEFANTE("Elefante",
                "https://www.pngmart.com/files/7/African-Elephant-PNG-File.png"),
        GALO("Galo",
                "https://static.vecteezy.com/system/resources/previews/010/792/673/non_2x/colorful-free-range-male-rooster-isolated-on-white-background-free-png.png"),

        // PNG
        GATO("Gato", "https://pngimg.com/uploads/cat/cat_PNG50491.png"),
        JACARE("Jacaré", "https://pngimg.com/uploads/crocodile/crocodile_PNG13171.png"),
        LEAO("Leão", "https://www.freeiconspng.com/uploads/big-male-lion-png-23.png"),
        MACACO("Macaco",
                "https://th.bing.com/th/id/R.c4b30b4e67a6d81861484de2b7fea6a2?rik=YOWMzRoxpDNYmg&riu=http%3a%2f%2fpngimg.com%2fuploads%2fmonkey%2fmonkey_PNG18727.png&ehk=w624iURv3aLOCwuY%2bTjYOROEIVgmjxCL0noqpzQi5OQ%3d&risl=&pid=ImgRaw&r=0"),
        PORCO("Porco", "https://pngimg.com/uploads/pig/pig_PNG2192.png"),
        PAVAO("Pavão", "https://www.pngarts.com/files/4/Peacock-PNG-Pic.png"),
        PERU("Peru",
                "https://th.bing.com/th/id/R.8a03ef5ad9d66552798973e28e060725?rik=0sl5%2b%2fl2dFrygw&riu=http%3a%2f%2fpngimg.com%2fuploads%2fturkey%2fturkey_PNG58599.png&ehk=aG8g5%2bdOcqqeq1fBVK0%2bNKJ0DaZV7%2fPHyVsYAGCU6Es%3d&risl=&pid=ImgRaw&r=0"),
        TOURO("Touro", "https://wowjohn.com/wp-content/uploads/2022/05/toro-png-4-Transparent-Images-Free.png"),
        TIGRE("Tigre", "https://freepngimg.com/thumb/tiger/11-2-tiger-png-image.png"),
        URSO("Urso", "https://th.bing.com/th/id/R.490fcc96a92fec402b2ed81223c74767?rik=of1SccnMTuGfKg&pid=ImgRaw&r=0"),
        VEADO("Veado",
                "https://th.bing.com/th/id/R.f5720c143faa8d11e3ab2ced3cefef59?rik=g%2fBcysMv8D0ANw&pid=ImgRaw&r=0"),
        VACA("Vaca",
                "https://purepng.com/public/uploads/large/purepng.com-cowmeatcowanimalgodmilkbuffalo-981524635397i1xu4.png");

        private final String texto;
        private final String imagem;

        private static final Map<String, String> imagensPorAnimal = new HashMap<>();

        static {
            for (Animais animal : values()) {
                imagensPorAnimal.put(animal.texto, animal.imagem);
            }
        }

        public static String getImagemPorAnimal(String animal) {
            return imagensPorAnimal.get(animal);
        }
    }

    public enum TipoCartao {
        CREDITO("Crédito"),
        DEBITO("Débito");

        public String texto;

        TipoCartao(String tipoCartao) {
            texto = tipoCartao;
        }
    }

}
