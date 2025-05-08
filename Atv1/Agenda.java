import java.util.ArrayList;

public class Agenda implements iAgenda {

    ArrayList<Consulta> agendaMedica = new ArrayList<Consulta>();

    public ArrayList<Consulta> getAgendaMedica() {
        return agendaMedica;
    }

    public void setAgendaMedica(ArrayList<Consulta> agendaMedica) {
        this.agendaMedica = agendaMedica;
    }

    @Override    
    public void cadastrarAgenda(Consulta consulta) {
        agendaMedica.add(consulta);
    }
    
    @Override
    public void editarConsulta(int codigo, Consulta consulta) {
        if(codigo < 0 || codigo >= agendaMedica.size()) {
            System.out.println("Consulta não encontrada.");
            return;
        }
        agendaMedica.set(codigo, consulta);
    }
    
    @Override
    public void imprimirConsulta(int codigo) {
        if(codigo < 0 || codigo >= agendaMedica.size()) {
            System.out.println("Consulta não encontrada.");
            return;
        }
        Consulta am = agendaMedica.get(codigo);
        System.out.println("Nome do paciente: " + am.getPaciente().getNome());
        System.out.println("Nome do especialista: " + am.getEspecialista().getNome());
        System.out.println("Horario: " + am.getHorario());
    }
    
    @Override
    public void imprimirTodos() {
        agendaMedica.forEach((Consulta am) -> {
            System.out.println("Nome do paciente: " + am.getPaciente().getNome());
            System.out.println("Nome do especialista: " + am.getEspecialista().getNome());
            System.out.println("Horario: " + am.getHorario());
        });
        
    }
    
}
