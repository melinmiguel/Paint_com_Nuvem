package bd.dbos;

public class Livro implements Cloneable
{
    private int    id;
    private String nome;
 
    public void setCodigo (int id) throws Exception
    {
        if (id <= 0)
            throw new Exception ("id invalido");

        this.id = id;
    }   

    public void setNome (String nome) throws Exception
    {
        if (nome ==null || nome.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }
   
    public int getCodigo ()
    {
        return this.id;
    }

    public String getNome ()
    {
        return this.nome;
    }

    
    public Livro (int id, String nome) throws Exception
    {
        this.setCodigo (id);
        this.setNome   (nome);
       }

    public String toString ()
    {
        String ret="";

        ret+="Codigo: "+this.id+"\n";
        ret+="Nome..: "+this.nome  +"\n";
     

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

        if (this.id!=liv.id)
            return false;

        if (this.nome.equals(liv.nome))
            return false;

    
        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.id).hashCode();
        ret = 7*ret + this.nome.hashCode();
    
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