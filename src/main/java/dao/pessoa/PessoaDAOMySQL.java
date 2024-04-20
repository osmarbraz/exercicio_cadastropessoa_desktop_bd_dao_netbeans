package dao.pessoa;

import dao.Conexao;
import dao.DadosBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Pessoa;

public class PessoaDAOMySQL implements PessoaDAO {

    public boolean salvar(Pessoa pessoa) {
        boolean resultado = false;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = null;
            if (pessoa.getPessoaId() != -1) {
                sql = "update pessoa set NOME=?, IDADE=?, DATANASCIMENTO=?, CIDADE=?, ESTADOCIVIL=? where PESSOAID = ?";
            } else {
                sql = "insert into pessoa (NOME, IDADE, DATANASCIMENTO, CIDADE, ESTADOCIVIL)  values  (?,?,?,?,?)";
            }
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getIdade());
            pstmt.setDate(3, new java.sql.Date(formatador.parse(pessoa.getDataNascimento()).getTime()));
            pstmt.setString(4, pessoa.getCidade());
            pstmt.setString(5, pessoa.getEstadoCivil());
            if (pessoa.getPessoaId() != -1) {
                pstmt.setInt(6, pessoa.getPessoaId());
            }
            pstmt.executeUpdate();
            resultado = true;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    public boolean apagarPK(int pessoaId) {
        boolean resultado = false;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = "delete from pessoa where pessoaId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pessoaId);
            pstmt.executeUpdate();
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    public Pessoa consultarPK(String pessoaId) {
        Pessoa pessoa = null;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pessoaId, nome, idade, DATE_FORMAT(dataNascimento, '%d/%m/%Y') as dataNascimento, cidade, estadoCivil from pessoa where pessoaId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(pessoaId));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setPessoaId(rs.getInt("pessoaId"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setIdade(rs.getString("idade"));
                pessoa.setDataNascimento(rs.getString("dataNascimento"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstadoCivil(rs.getString("estadoCivil"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return pessoa;
    }

    public List consultarTudo() {
        Pessoa pessoa = null;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        try {
            String sql = "select * from pessoa";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setPessoaId(rs.getInt("pessoaId"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setIdade(rs.getString("idade"));
                pessoa.setDataNascimento(rs.getString("dataNascimento"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstadoCivil(rs.getString("estadoCivil"));
                lista.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lista;
    }
}
