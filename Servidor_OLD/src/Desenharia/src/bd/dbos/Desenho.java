package bd.dbos;

public class Desenho implements Cloneable
{
    
    private String nome;
    private String dataCriacao;
    private String dataUltimaAtualizacao;
    private String conteudo;

 public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }

    public void setDataCriacao (String dataCriacao) throws Exception
    {
        if (dataCriacao==null || dataCriacao.equals(""))
            throw new Exception ("Data nao fornecido");

        this.dataCriacao = dataCriacao;
    }
    public void setdataUltimaAtualizacao (String dataUltimaAtualizacao) throws Exception
    {
        if (dataUltimaAtualizacao==null || dataUltimaAtualizacao.equals(""))
            throw new Exception ("dataUltimaAtualizacao nao fornecido");

        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
    public void setConteudo (String conteudo) throws Exception
    {
        if (conteudo==null || conteudo.equals(""))
            throw new Exception ("Conteudo nao fornecido");

        this.conteudo = conteudo;
    }

   public String getNome ()
    {
        return this.nome;
    }

    public String getDataCriacao ()
    {
        return this.dataCriacao;
    }
    
    public String getDataUltimaAtualizacao ()
    {
        return this.dataUltimaAtualizacao;
    }
    
    public String getConteudo ()
    {
        return this.conteudo;
    }
    public Desenho (String nome, String dataCriacao,String dataUltimaAtualizacao, String conteudo) throws Exception
    {
      
        this.setNome   (nome);
        this.setDataCriacao(dataCriacao);
        this.setdataUltimaAtualizacao(dataUltimaAtualizacao);
        this.setConteudo(conteudo);
    }

    public String toString ()
    {
        String ret="";

        ret+="Nome: "+this.nome+"\n";
        ret+="Conteudo..: "+this.conteudo  +"\n";
       

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Desenho))
            return false;

        Desenho liv = (Desenho)obj;

       if (this.nome.equals(liv.nome))
            return false;

        if (this.dataCriacao!=liv.dataCriacao)
            return false;

        if (this.dataUltimaAtualizacao!=liv.dataUltimaAtualizacao)
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666;

      //  ret = 7*ret + new Integer(this.codigo).hashCode();
       // ret = 7*ret + this.nome.hashCode();
       // ret = 7*ret + new Float(this.preco).hashCode();

        return ret;
    }


    public Desenho (Desenho modelo) throws Exception
    {
        this.nome   = modelo.nome;   // nao clono, pq nao eh clonavel
        this.preco  = modelo.preco;  // nao clono, pq nao eh objeto
        this.dataCriacao = modelo.dataCriacao;
        this.dataUltimaAtualizacao = modelo.dataUltimaAtualizacao;
   }

    public Object clone ()
    {
        Desenho ret=null;

        try
        {
            ret = new Desenho (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca � null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}