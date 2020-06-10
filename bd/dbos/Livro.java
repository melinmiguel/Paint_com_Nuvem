package bd.dbos;

public class Livro implements Cloneable
{
    private int    Id;
    private String Nome;
 
    public void setCodigo (int id) throws Exception
    {
        if (id <= 0)
            throw new Exception ("id invalido");

        this.Id = Id;
    }   

    public void setNome (String nome) throws Exception
    {
        if (nome ==null || nome.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.Nome = Nome;
    }
   
    public int getCodigo ()
    {
        return this.Id;
    }

    public String getNome ()
    {
        return this.Nome;
    }

    
    public Livro (int id, String Nome) throws Exception
    {
        this.setCodigo (Id);
        this.setNome   (Nome);
       }

    public String toString ()
    {
        String ret="";

        ret+="Codigo: "+this.Id+"\n";
        ret+="Nome..: "+this.Nome  +"\n";
     

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Livro))
            return false;

        Livro liv = (Livro)obj;

        if (this.Id!=liv.Id)
            return false;

        if (this.Nome.equals(liv.Nome))
            return false;

    
        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.Id).hashCode();
        ret = 7*ret + this.Nome.hashCode();
    
        return ret;
    }


    public Livro (Livro modelo) throws Exception
    {
        this.id = modelo.id; // nao clono, pq nao eh objeto
        this.nome   = modelo.nome;   // nao clono, pq nao eh clonavel
       }

    public Object clone ()
    {
        Livro ret=null;

        try
        {
            ret = new Livro (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca � null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}