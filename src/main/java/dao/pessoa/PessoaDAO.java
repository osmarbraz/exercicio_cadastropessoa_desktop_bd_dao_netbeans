package dao.pessoa;

import java.util.List;
import modelo.Pessoa;

public interface PessoaDAO {

    public boolean salvar(Pessoa pessoa);

    public Pessoa consultarPK(String pessoaId);

    public boolean apagarPK(int pessoaId);

    public List consultarTudo();
}
