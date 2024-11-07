package repositorio;

import dominio.Curso;
import fakedb.CursoFakeDb;

public class CursoRepositorio extends BaseRepositorio<Curso>
{
 
    private CursoFakeDb db;

    public CursoRepositorio()
    {
        this.db = new CursoFakeDb();
        this.fonteDeDados = this.db.getTabela();
    }

    @Override
    public Curso Create(Curso instancia)
    {
        int pos = this.fonteDeDados.size() - 1;
        Curso cp = this.fonteDeDados.get(pos);
        int proxChave = cp.getCodigo() + 1;
        instancia.setCodigo(proxChave);
        this.fonteDeDados.add(instancia);
        return instancia;
    }

    @Override
    public Curso Delete(int chave)
    {
        Curso cp = this.Read(chave);
        if (cp != null)
        {
            this.fonteDeDados.remove(cp);
            return cp;
        }
        else
        {
            return null;
        }        
    }

    @Override
    public Curso Read(int chave)
    {
        for (Curso cp : this.fonteDeDados)
        {
            if(cp.getCodigo() == chave)
            {
                return cp;
            }
        }
        return null;
    }

    @Override
    public Curso Update(Curso instancia)
    {
        Curso cp = this.Read(instancia.getCodigo());
        if (cp != null)
        {
            cp.setDescricao(instancia.getDescricao());
            cp.setNome(instancia.getNome());
            cp.setCargahr(instancia.getCargahr());
            return cp;
        }
        else
        {
            return null;
        }
    }
    
    
}