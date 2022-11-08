import java.util.*;

public class Main {
    public static void main(String[] args){
        Hashtable<String, ArrayList<String>> tabela = new Hashtable<String, ArrayList<String>>();

        ArrayList<String> contatosMilena = new ArrayList<String>();
        contatosMilena.add("Yadira");
        contatosMilena.add("Juan");

        ArrayList<String> contatosJuan = new ArrayList<String>();
        contatosJuan.add("Maria");
        contatosJuan.add("Milena");
        contatosJuan.add("Lucia");


        ArrayList<String> contatosAndres = new ArrayList<String>();
        contatosAndres.add("Maria");

        ArrayList<String> contatosJavier = new ArrayList<String>();
        contatosJavier.add("Milena");
        contatosJavier.add("Yadira");

        ArrayList<String> contatosYadira = new ArrayList<String>();
        contatosYadira.add("Lucua");


        tabela.put("Milena", contatosMilena);
        tabela.put("Juan", contatosJuan);
        tabela.put("Andres", contatosAndres);
        tabela.put("Javier", contatosJavier);
        tabela.put("Yadira", contatosYadira);

        showData(tabela);

        System.out.println(pesquisaEmLargura(tabela, "Javier"));

    }

    private static String pesquisaEmLargura(Hashtable<String, ArrayList<String>> tabela, String pontoInicial) {
        Queue<String> fila = new LinkedList<String>();
        ArrayList<String> verificados = new ArrayList<String>();

        fila = enfileirar(fila, (ArrayList<String>) tabela.get(pontoInicial));

        String nomeBusca = null;
        while ((fila.size() > 0)) {
            String pessoa = fila.poll();

            nomeBusca = "Maria";

            if (nomeBusca.equals(pessoa)) {
                return pessoa + " encontrou " + nomeBusca;
            }

            if (verificados.contains(pessoa)) {
                continue;
            }

            fila = enfileirar(fila, (ArrayList<String>) tabela.get(pessoa));
            verificados.add(pessoa);
        }

        return pontoInicial + ", não encontrou " + nomeBusca;
    }

    private static  Queue<String> enfileirar(Queue<String> fila, ArrayList<String> lista){
        if(lista == null){
            return fila;
        }

        for (String item : lista) {
            fila.offer(item);
        }

        return fila;

    }

    private static void showData(Hashtable<String, ArrayList<String>> tabela){
        for (Map.Entry<String, ArrayList<String>> entry : tabela.entrySet()){
            String nome = entry.getKey();
            ArrayList<String> contato = entry.getValue();

            System.out.println(nome + " Encontrou " + contato);
        }
    }


}
