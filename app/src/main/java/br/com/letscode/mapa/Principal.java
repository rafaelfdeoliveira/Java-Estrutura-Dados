package br.com.letscode.mapa;

//import br.com.letscode.dominio.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
//        Map<String, String> mapa = new HashMap<>();
//        mapa.put("user1", "maria1@maria.com");
//        mapa.put("user2", "maria2@maria.com");
//        mapa.put("user3", "maria3@maria.com");
//        mapa.put("user4", "maria4@maria.com");
//        mapa.put("user5", "maria5@maria.com");
//        // A chave tem que ser unica. Nao da erro se duas chaves iguais foram usadas mas so a ultima inserida permanecera
//        // Mapa nao garante ordem dos itens mas e muito perfomatico. Acessar, inserir e muito rapido
//        System.out.println(mapa);
//
//        String user1Email = mapa.get("user1");
//
//        // Necessita do método equals para usar o containsKey (Para Strings o java já tem o equals mas para os nossos objetos criados devemos implementar esse metodo)
//        if (mapa.containsKey("jorge")) {
//            System.out.println("chave encontrada");
//        } else {
//            System.out.println("chave inexistente");
//        }
//        // containsValue e muito menos perfomatico que containsKey
//        boolean value = mapa.containsValue("8888-8888");
//
//        Set<String> chaves = mapa.keySet();
//        for (String chave: chaves) {
//            System.out.println("chave: " + chave);
//        }
//
//        Collection<String> values = mapa.values();
//        List<String> list = new ArrayList<>(values);
//        Set<Map.Entry<String, String>> entrada = mapa.entrySet();
//        for (Map.Entry<String, String> i: entrada) {
//            String chave = i.getKey();
//            String valor = i.getValue();
//            System.out.println(chave + " - " + valor);
//        }

//        Map<Integer, Integer> cepMap = new HashMap<>();
//        cepMap.put(22630010, 20);
//        cepMap.put(22780081, 30);
//        cepMap.put(21431323, 40);
//        cepMap.put(23232323, 10);
//
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Insira o CEP para calcular o frete: ");
//        String answer = sc.nextLine();
//        Integer cep = Integer.parseInt(answer);
//        Integer cost = cepMap.get(cep);
//        System.out.println("Valor total do frete = " + cost);

//        Map<String, Integer> urna = new HashMap<>();
//        urna.put("Rafael", 0);
//        urna.put("Jorge", 0);
//        urna.put("Gabriela", 0);
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < 10; i++) {
//            String answer;
//            while (true) {
//                System.out.print("Insira o nome de um candidato para receber um voto: ");
//                answer = sc.nextLine();
//                if (urna.containsKey(answer)) break;
//                System.out.println("Os candidatos válidos são: Rafael, Jorge e Gabriela");
//            }
//            int votos = urna.get(answer);
//            urna.put(answer, votos + 1);
//        }

//        String palavra = "letscode";
//        boolean isDuplicada = isLetraDuplicada(palavra);
//
//        String msg = isDuplicada ? "Existem letras duplicadas" : "não existem letras duplicadas");
//
//        System.out.println(msg);
//
//    }
//
//    // O(n log n)
//    public static boolean isLetraDuplicada(char[] array) {
//
//        boolean[] alfabeto = new boolean[26];
//
//        for (char c : array) {
//            int posicaoLetra = c - 'a';
//            if (alfabeto[posicaoLetra]) return true;
//            else alfabeto[posicaoLetra] = true;
//        }
//        return false;

//        Map<Character, Integer> mapa = new HashMap<>();
//        Set<Character> set = new HashSet<>();
//
//        for (int i = 0; i < array.length; i++) {
//          set.add(array[i]);
//        }
//
//        System.out.println("tamanho set " + set.size());
//        System.out.println("tamanho array " + array.length);
//
//
//        for (int i = 0; i < array.length; i++) {
//            char letraFor = array[i];
//            Integer letra = mapa.get(letraFor);
//            if (letra != null) return true;
//            else mapa.put(letra);
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            char letraDoPrimeiroFor = array[i];
//            for (int j = i + 1; j < array.length; j++) {
//                char letraDoSegundoFor = array[j];
//                if (letraDoSegundoFor == letraDoSegundoFor) return true;
//            }
//        }
//        return false;

//        new hasRepeatedWord();

        // LIST
        // SET
        // MAP
        // QUEUE

        // COLLECTION

//        Set<Pessoa> pessoas = new HashSet<>();
//        pessoas.add(new Pessoa("jorge"));
//        pessoas.add(new Pessoa("joao"));
//        pessoas.add(new Pessoa("maria"));
//        pessoas.add(new Pessoa("hugo"));
//        pessoas.add(new Pessoa("eduarda"));
//        System.out.println(pessoas);

        // HashSet não garante ordem mas é o mais rápido para buscar e inserir no meio
        // TreeSet garante a ordem de acordo com o método compareTo.
        // LinkedHashSet ordena com a sua própria lógica


        // Para usar a estrutura TreeSet, o objeto usado (nesse caso Pessoa) precisa ter o método compareTo implementado para não dar erro.
        // O TreeSet usa esse método compareTo para ordenar os objetos Pessoa adicionados
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("jorge"));
        pessoas.add(new Pessoa("joao"));
        pessoas.add(new Pessoa("maria"));
        pessoas.add(new Pessoa("hugo"));
        pessoas.add(new Pessoa("eduarda"));
        System.out.println(pessoas);

        Collections.sort(pessoas, Comparator
                .comparing(Pessoa::getNome)
                .thenComparing(Pessoa::getIdade)
                .thenComparing(Pessoa::getTamanho));

    }
}

@Data
@AllArgsConstructor
class Pessoa implements Comparable<Pessoa>, Comparator<Pessoa> {
    private String nome;
    private int tamanho;
    private int idade;

    public Pessoa(String nome) {
        this.nome = nome;
        this.tamanho = (int) Math.random();
        this.idade = (int) Math.random();
    }

    @Override
    public int compareTo(Pessoa o) {
        return nome.compareTo(o.getNome());
    }

    @Override
    public int compare() {

    }
}
