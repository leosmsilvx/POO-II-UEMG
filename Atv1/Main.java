import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Agenda clinica = new Agenda();

        Scanner sc = new Scanner(System.in);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Escolha uma opcao:");
            System.out.println("- 1: Imprimir todas as consultas");
            System.out.println("- 2: Imprimir consulta por codigo");
            System.out.println("- 3: Editar consulta por codigo");
            System.out.println("- 4: Cadastrar nova consulta");
            System.out.println("- 0: Sair");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    clinica.imprimirTodos();
                    break;                   
                case 2:
                    System.out.println("Digite o codigo da consulta:");
                    int codConsulta = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer do scanner
                    clinica.imprimirConsulta(codConsulta);
                    break;                   
                case 3:
                    System.out.println("Digite o codigo da consulta:");
                    int codEditar = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer do scanner
                    clinica.editarConsulta(codEditar, getDadosConsulta(sc, codEditar));
                    break;                   
                case 4:
                    int codCadastrar = clinica.getAgendaMedica().size() + 1;
                    clinica.cadastrarAgenda(getDadosConsulta(sc, codCadastrar));
                    break;                   
                case 0:
                    opcao = 0;
                    break;                   
            }
        }

        sc.close();

        return;
    }

    public static Consulta getDadosConsulta(Scanner sc, int codigo){
        System.out.println("Digite a data da consulta:");
        Data data = getDataConsulta(sc);
        
        System.out.println("Digite o nome do especialista:");
        String nomeEspecialista = sc.nextLine();
        Profissional especialista = new Profissional();
        especialista.setNome(nomeEspecialista);
        
        Paciente paciente = new Paciente();
        
        System.out.println("Digite o horario da consulta:");
        String horario = sc.nextLine();
        
        System.out.println("Digite a descricao do sintoma:");
        String descricaoSintoma = sc.nextLine();
        
        System.out.println("Digite a prescricao:");
        String prescricao = sc.nextLine();
        
        Consulta consulta = new Consulta(codigo, data, especialista);
        consulta.setPaciente(paciente);
        consulta.setHorario(horario);
        consulta.setDescricaoSintoma(descricaoSintoma);
        consulta.setPrescricao(prescricao);

        return consulta;

    }

    public static Data getDataConsulta(Scanner sc){
        System.out.println("Digite o dia:");
        int dia = sc.nextInt();
        sc.nextLine(); // Limpar o buffer do scanner
        System.out.println("Digite o mes:");
        String mes = sc.nextLine();
        System.out.println("Digite o ano:");
        int ano = sc.nextInt();
        sc.nextLine(); // Limpar o buffer do scanner

        Data data = new Data();
        data.setDia(dia);
        data.setMes(mes);
        data.setAno(ano);
        return data;
    }

}
