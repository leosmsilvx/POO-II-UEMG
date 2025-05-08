public interface iAgenda {
    public void cadastrarAgenda(Consulta consulta);
    public void editarConsulta(int codigo, Consulta consulta);
    public void imprimirTodos();
    public void imprimirConsulta(int codigo);
}
