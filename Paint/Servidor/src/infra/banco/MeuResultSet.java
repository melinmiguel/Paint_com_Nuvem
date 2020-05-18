package src.infra.banco;

import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

import java.io.InputStream;
import java.io.Reader;

import java.math.BigDecimal;

import java.net.URL;

import java.util.Calendar;
import java.util.Map;

public class MeuResultSet implements ResultSet {
  protected Statement comando;
  protected ResultSet resultado;

  protected MeuResultSet(Statement c, ResultSet r) {
    this.comando = c;
    this.resultado = r;
  }

  // metodos herdados da interface ResultSet

  @Override
  public boolean absolute(int row) throws SQLException {
    return this.resultado.absolute(row);
  }

  @Override
  public void afterLast() throws SQLException {
    this.resultado.afterLast();
  }

  @Override
  public void beforeFirst() throws SQLException {
    this.resultado.beforeFirst();
  }

  @Override
  public void cancelRowUpdates() throws SQLException {
    this.resultado.cancelRowUpdates();
  }

  @Override
  public void clearWarnings() throws SQLException {
    this.resultado.clearWarnings();
  }

  @Override
  public void close() throws SQLException {
    this.resultado.close();
    this.comando.close();
  }

  @Override
  public void deleteRow() throws SQLException {
    this.resultado.deleteRow();
  }

  @Override
  public int findColumn(String columnLabel) throws SQLException {
    return this.resultado.findColumn(columnLabel);
  }

  @Override
  public boolean first() throws SQLException {
    return this.resultado.first();
  }

  @Override
  public Array getArray(int columnIndex) throws SQLException {
    return this.resultado.getArray(columnIndex);
  }

  @Override
  public Array getArray(String columnLabel) throws SQLException {
    return this.resultado.getArray(columnLabel);
  }

  @Override
  public InputStream getAsciiStream(int columnIndex) throws SQLException {
    return this.resultado.getAsciiStream(columnIndex);
  }

  @Override
  public InputStream getAsciiStream(String columnLabel) throws SQLException {
    return this.resultado.getAsciiStream(columnLabel);
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    return this.resultado.getBigDecimal(columnIndex);
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    return this.resultado.getBigDecimal(columnIndex, scale);
  }

  @Override
  public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
    return this.resultado.getBigDecimal(columnLabel);
  }

  @Override
  public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
    return this.resultado.getBigDecimal(columnLabel, scale);
  }

  @Override
  public InputStream getBinaryStream(int columnIndex) throws SQLException {
    return this.resultado.getBinaryStream(columnIndex);
  }

  @Override
  public InputStream getBinaryStream(String columnLabel) throws SQLException {
    return this.resultado.getBinaryStream(columnLabel);
  }

  @Override
  public Blob getBlob(int columnIndex) throws SQLException {
    return this.resultado.getBlob(columnIndex);
  }

  @Override
  public Blob getBlob(String columnLabel) throws SQLException {
    return this.resultado.getBlob(columnLabel);
  }

  @Override
  public boolean getBoolean(int columnIndex) throws SQLException {
    return this.resultado.getBoolean(columnIndex);
  }

  @Override
  public boolean getBoolean(String columnLabel) throws SQLException {
    return this.resultado.getBoolean(columnLabel);
  }

  @Override
  public byte getByte(int columnIndex) throws SQLException {
    return this.resultado.getByte(columnIndex);
  }

  @Override
  public byte getByte(String columnLabel) throws SQLException {
    return this.resultado.getByte(columnLabel);
  }

  @Override
  public byte[] getBytes(int columnIndex) throws SQLException {
    return this.resultado.getBytes(columnIndex);
  }

  @Override
  public byte[] getBytes(String columnLabel) throws SQLException {
    return this.resultado.getBytes(columnLabel);
  }

  @Override
  public Reader getCharacterStream(int columnIndex) throws SQLException {
    return this.resultado.getCharacterStream(columnIndex);
  }

  @Override
  public Reader getCharacterStream(String columnLabel) throws SQLException {
    return this.resultado.getCharacterStream(columnLabel);
  }

  @Override
  public Clob getClob(int columnIndex) throws SQLException {
    return this.resultado.getClob(columnIndex);
  }

  @Override
  public Clob getClob(String columnLabel) throws SQLException {
    return this.resultado.getClob(columnLabel);
  }

  @Override
  public int getConcurrency() throws SQLException {
    return this.resultado.getConcurrency();
  }

  @Override
  public String getCursorName() throws SQLException {
    return this.resultado.getCursorName();
  }

  @Override
  public Date getDate(int columnIndex) throws SQLException {
    return this.resultado.getDate(columnIndex);
  }

  @Override
  public Date getDate(int columnIndex, Calendar cal) throws SQLException {
    return this.resultado.getDate(columnIndex, cal);
  }

  @Override
  public Date getDate(String columnLabel) throws SQLException {
    return this.resultado.getDate(columnLabel);
  }

  @Override
  public Date getDate(String columnLabel, Calendar cal) throws SQLException {
    return this.resultado.getDate(columnLabel, cal);
  }

  @Override
  public double getDouble(int columnIndex) throws SQLException {
    return this.resultado.getDouble(columnIndex);
  }

  @Override
  public double getDouble(String columnLabel) throws SQLException {
    return this.resultado.getDouble(columnLabel);
  }

  @Override
  public int getFetchDirection() throws SQLException {
    return this.resultado.getFetchDirection();
  }

  @Override
  public int getFetchSize() throws SQLException {
    return this.resultado.getFetchSize();
  }

  @Override
  public float getFloat(int columnIndex) throws SQLException {
    return this.resultado.getFloat(columnIndex);
  }

  @Override
  public float getFloat(String columnLabel) throws SQLException {
    return this.resultado.getFloat(columnLabel);
  }

  @Override
  public int getHoldability() throws SQLException {
    return this.resultado.getHoldability();
  }

  @Override
  public int getInt(int columnIndex) throws SQLException {
    return this.resultado.getInt(columnIndex);
  }

  @Override
  public int getInt(String columnLabel) throws SQLException {
    return this.resultado.getInt(columnLabel);
  }

  @Override
  public long getLong(int columnIndex) throws SQLException {
    return this.resultado.getLong(columnIndex);
  }

  @Override
  public long getLong(String columnLabel) throws SQLException {
    return this.resultado.getLong(columnLabel);
  }

  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    return this.resultado.getMetaData();
  }

  @Override
  public Reader getNCharacterStream(int columnIndex) throws SQLException {
    return this.resultado.getNCharacterStream(columnIndex);
  }

  @Override
  public Reader getNCharacterStream(String columnLabel) throws SQLException {
    return this.resultado.getNCharacterStream(columnLabel);
  }

  @Override
  public NClob getNClob(int columnIndex) throws SQLException {
    return this.resultado.getNClob(columnIndex);
  }

  @Override
  public NClob getNClob(String columnLabel) throws SQLException {
    return this.resultado.getNClob(columnLabel);
  }

  @Override
  public String getNString(int columnIndex) throws SQLException {
    return this.resultado.getNString(columnIndex);
  }

  @Override
  public String getNString(String columnLabel) throws SQLException {
    return this.resultado.getNString(columnLabel);
  }

  @Override
  public Object getObject(int columnIndex) throws SQLException {
    return this.resultado.getObject(columnIndex);
  }

  @Override
  public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
    return this.resultado.getObject(columnIndex, type);
  }

  @Override
  public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
    return this.resultado.getObject(columnIndex, map);
  }

  @Override
  public Object getObject(String columnLabel) throws SQLException {
    return this.resultado.getObject(columnLabel);
  }

  @Override
  public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
    return this.resultado.getObject(columnLabel, type);
  }

  @Override
  public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
    return this.resultado.getObject(columnLabel, map);
  }

  @Override
  public Ref getRef(int columnIndex) throws SQLException {
    return this.resultado.getRef(columnIndex);
  }

  @Override
  public Ref getRef(String columnLabel) throws SQLException {
    return this.resultado.getRef(columnLabel);
  }

  @Override
  public int getRow() throws SQLException {
    return this.resultado.getRow();
  }

  @Override
  public RowId getRowId(int columnIndex) throws SQLException {
    return this.resultado.getRowId(columnIndex);
  }

  @Override
  public RowId getRowId(String columnLabel) throws SQLException {
    return this.resultado.getRowId(columnLabel);
  }

  @Override
  public short getShort(int columnIndex) throws SQLException {
    return this.resultado.getShort(columnIndex);
  }

  @Override
  public short getShort(String columnLabel) throws SQLException {
    return this.resultado.getShort(columnLabel);
  }

  @Override
  public SQLXML getSQLXML(int columnIndex) throws SQLException {
    return this.resultado.getSQLXML(columnIndex);
  }

  @Override
  public SQLXML getSQLXML(String columnLabel) throws SQLException {
    return this.resultado.getSQLXML(columnLabel);
  }

  @Override
  public Statement getStatement() throws SQLException {
    return this.resultado.getStatement();
  }

  @Override
  public String getString(int columnIndex) throws SQLException {
    return this.resultado.getString(columnIndex);
  }

  @Override
  public String getString(String columnLabel) throws SQLException {
    return this.resultado.getString(columnLabel);
  }

  @Override
  public Time getTime(int columnIndex) throws SQLException {
    return this.resultado.getTime(columnIndex);
  }

  @Override
  public Time getTime(int columnIndex, Calendar cal) throws SQLException {
    return this.resultado.getTime(columnIndex, cal);
  }

  @Override
  public Time getTime(String columnLabel) throws SQLException {
    return this.resultado.getTime(columnLabel);
  }

  @Override
  public Time getTime(String columnLabel, Calendar cal) throws SQLException {
    return this.resultado.getTime(columnLabel, cal);
  }

  @Override
  public Timestamp getTimestamp(int columnIndex) throws SQLException {
    return this.resultado.getTimestamp(columnIndex);
  }

  @Override
  public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
    return this.resultado.getTimestamp(columnIndex, cal);
  }

  @Override
  public Timestamp getTimestamp(String columnLabel) throws SQLException {
    return this.resultado.getTimestamp(columnLabel);
  }

  @Override
  public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
    return this.resultado.getTimestamp(columnLabel, cal);
  }

  @Override
  public int getType() throws SQLException {
    return this.resultado.getType();
  }

  @Override
  public InputStream getUnicodeStream(int columnIndex) throws SQLException {
    return this.resultado.getUnicodeStream(columnIndex);
  }

  @Override
  public InputStream getUnicodeStream(String columnLabel) throws SQLException {
    return this.resultado.getUnicodeStream(columnLabel);
  }

  @Override
  public URL getURL(int columnIndex) throws SQLException {
    return this.resultado.getURL(columnIndex);
  }

  @Override
  public URL getURL(String columnLabel) throws SQLException {
    return this.resultado.getURL(columnLabel);
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    return this.resultado.getWarnings();
  }

  @Override
  public void insertRow() throws SQLException {
    this.resultado.insertRow();
  }

  @Override
  public boolean isAfterLast() throws SQLException {
    return this.resultado.isAfterLast();
  }

  @Override
  public boolean isBeforeFirst() throws SQLException {
    return this.resultado.isBeforeFirst();
  }

  @Override
  public boolean isClosed() throws SQLException {
    return this.resultado.isClosed();
  }

  @Override
  public boolean isFirst() throws SQLException {
    return this.resultado.isFirst();
  }

  @Override
  public boolean isLast() throws SQLException {
    return this.resultado.isLast();
  }

  @Override
  public boolean last() throws SQLException {
    return this.resultado.last();
  }

  @Override
  public void moveToCurrentRow() throws SQLException {
    this.resultado.moveToCurrentRow();
  }

  @Override
  public void moveToInsertRow() throws SQLException {
    this.resultado.moveToInsertRow();
  }

  @Override
  public boolean next() throws SQLException {
    return this.resultado.next();
  }

  @Override
  public boolean previous() throws SQLException {
    return this.resultado.previous();
  }

  @Override
  public void refreshRow() throws SQLException {
    this.resultado.refreshRow();
  }

  @Override
  public boolean relative(int rows) throws SQLException {
    return this.resultado.relative(rows);
  }

  @Override
  public boolean rowDeleted() throws SQLException {
    return this.resultado.rowDeleted();
  }

  @Override
  public boolean rowInserted() throws SQLException {
    return this.resultado.rowInserted();
  }

  @Override
  public boolean rowUpdated() throws SQLException {
    return this.resultado.rowUpdated();
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    this.resultado.setFetchDirection(direction);
  }

  @Override
  public void setFetchSize(int rows) throws SQLException {
    this.resultado.setFetchSize(rows);
  }

  @Override
  public void updateArray(int columnIndex, Array x) throws SQLException {
    this.resultado.updateArray(columnIndex, x);
  }

  @Override
  public void updateArray(String columnLabel, Array x) throws SQLException {
    this.resultado.updateArray(columnLabel, x);
  }

  @Override
  public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
    this.resultado.updateAsciiStream(columnIndex, x);
  }

  @Override
  public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
    this.resultado.updateAsciiStream(columnIndex, x, length);
  }

  @Override
  public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
    this.resultado.updateAsciiStream(columnIndex, x, length);
  }

  @Override
  public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
    this.resultado.updateAsciiStream(columnLabel, x);
  }

  @Override
  public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
    this.resultado.updateAsciiStream(columnLabel, x, length);
  }

  @Override
  public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
    this.resultado.updateAsciiStream(columnLabel, x, length);
  }

  @Override
  public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
    this.resultado.updateBigDecimal(columnIndex, x);
  }

  @Override
  public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
    this.resultado.updateBigDecimal(columnLabel, x);
  }

  @Override
  public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
    this.resultado.updateBinaryStream(columnIndex, x);
  }

  @Override
  public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
    this.resultado.updateBinaryStream(columnIndex, x, length);
  }

  @Override
  public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
    this.resultado.updateBinaryStream(columnIndex, x, length);
  }

  @Override
  public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
    this.resultado.updateBinaryStream(columnLabel, x);
  }

  @Override
  public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
    this.resultado.updateBinaryStream(columnLabel, x, length);
  }

  @Override
  public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
    this.resultado.updateBinaryStream(columnLabel, x, length);
  }

  @Override
  public void updateBlob(int columnIndex, Blob x) throws SQLException {
    this.resultado.updateBlob(columnIndex, x);
  }

  @Override
  public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
    this.resultado.updateBlob(columnIndex, inputStream);
  }

  @Override
  public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
    this.resultado.updateBlob(columnIndex, inputStream, length);
  }

  @Override
  public void updateBlob(String columnLabel, Blob x) throws SQLException {
    this.resultado.updateBlob(columnLabel, x);
  }

  @Override
  public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
    this.resultado.updateBlob(columnLabel, inputStream);
  }

  @Override
  public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
    this.resultado.updateBlob(columnLabel, inputStream, length);
  }

  @Override
  public void updateBoolean(int columnIndex, boolean x) throws SQLException {
    this.resultado.updateBoolean(columnIndex, x);
  }

  @Override
  public void updateBoolean(String columnLabel, boolean x) throws SQLException {
    this.resultado.updateBoolean(columnLabel, x);
  }

  @Override
  public void updateByte(int columnIndex, byte x) throws SQLException {
    this.resultado.updateByte(columnIndex, x);
  }

  @Override
  public void updateByte(String columnLabel, byte x) throws SQLException {
    this.resultado.updateByte(columnLabel, x);
  }

  @Override
  public void updateBytes(int columnIndex, byte[] x) throws SQLException {
    this.resultado.updateBytes(columnIndex, x);
  }

  @Override
  public void updateBytes(String columnLabel, byte[] x) throws SQLException {
    this.resultado.updateBytes(columnLabel, x);
  }

  @Override
  public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
    this.resultado.updateCharacterStream(columnIndex, x);
  }

  @Override
  public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
    this.resultado.updateCharacterStream(columnIndex, x, length);
  }

  @Override
  public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
    this.resultado.updateCharacterStream(columnIndex, x, length);
  }

  @Override
  public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
    this.resultado.updateCharacterStream(columnLabel, reader);
  }

  @Override
  public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
    this.resultado.updateCharacterStream(columnLabel, reader, length);
  }

  @Override
  public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
    this.resultado.updateCharacterStream(columnLabel, reader, length);
  }

  @Override
  public void updateClob(int columnIndex, Clob x) throws SQLException {
    this.resultado.updateClob(columnIndex, x);
  }

  @Override
  public void updateClob(int columnIndex, Reader reader) throws SQLException {
    this.resultado.updateClob(columnIndex, reader);
  }

  @Override
  public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
    this.resultado.updateClob(columnIndex, reader, length);
  }

  @Override
  public void updateClob(String columnLabel, Clob x) throws SQLException {
    this.resultado.updateClob(columnLabel, x);
  }

  @Override
  public void updateClob(String columnLabel, Reader reader) throws SQLException {
    this.resultado.updateClob(columnLabel, reader);
  }

  @Override
  public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
    this.resultado.updateClob(columnLabel, reader, length);
  }

  @Override
  public void updateDate(int columnIndex, Date x) throws SQLException {
    this.resultado.updateDate(columnIndex, x);
  }

  @Override
  public void updateDate(String columnLabel, Date x) throws SQLException {
    this.resultado.updateDate(columnLabel, x);
  }

  @Override
  public void updateDouble(int columnIndex, double x) throws SQLException {
    this.resultado.updateDouble(columnIndex, x);
  }

  @Override
  public void updateDouble(String columnLabel, double x) throws SQLException {
    this.resultado.updateDouble(columnLabel, x);
  }

  @Override
  public void updateFloat(int columnIndex, float x) throws SQLException {
    this.resultado.updateFloat(columnIndex, x);
  }

  @Override
  public void updateFloat(String columnLabel, float x) throws SQLException {
    this.resultado.updateFloat(columnLabel, x);
  }

  @Override
  public void updateInt(int columnIndex, int x) throws SQLException {
    this.resultado.updateInt(columnIndex, x);
  }

  @Override
  public void updateInt(String columnLabel, int x) throws SQLException {
    this.resultado.updateInt(columnLabel, x);
  }

  @Override
  public void updateLong(int columnIndex, long x) throws SQLException {
    this.resultado.updateLong(columnIndex, x);
  }

  @Override
  public void updateLong(String columnLabel, long x) throws SQLException {
    this.resultado.updateLong(columnLabel, x);
  }

  @Override
  public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
    this.resultado.updateNCharacterStream(columnIndex, x);
  }

  @Override
  public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
    this.resultado.updateNCharacterStream(columnIndex, x, length);
  }

  @Override
  public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
    this.resultado.updateNCharacterStream(columnLabel, reader);
  }

  @Override
  public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
    this.resultado.updateNCharacterStream(columnLabel, reader, length);
  }

  @Override
  public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
    this.resultado.updateNClob(columnIndex, nClob);
  }

  @Override
  public void updateNClob(int columnIndex, Reader reader) throws SQLException {
    this.resultado.updateNClob(columnIndex, reader);
  }

  @Override
  public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
    this.resultado.updateNClob(columnIndex, reader, length);
  }

  @Override
  public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
    this.resultado.updateNClob(columnLabel, nClob);
  }

  @Override
  public void updateNClob(String columnLabel, Reader reader) throws SQLException {
    this.resultado.updateNClob(columnLabel, reader);
  }

  @Override
  public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
    this.resultado.updateNClob(columnLabel, reader, length);
  }

  @Override
  public void updateNString(int columnIndex, String nString) throws SQLException {
    this.resultado.updateNString(columnIndex, nString);
  }

  @Override
  public void updateNString(String columnLabel, String nString) throws SQLException {
    this.resultado.updateNString(columnLabel, nString);
  }

  @Override
  public void updateNull(int columnIndex) throws SQLException {
    this.resultado.updateNull(columnIndex);
  }

  @Override
  public void updateNull(String columnLabel) throws SQLException {
    this.resultado.updateNull(columnLabel);
  }

  @Override
  public void updateObject(int columnIndex, Object x) throws SQLException {
    this.resultado.updateObject(columnIndex, x);
  }

  @Override
  public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
    this.resultado.updateObject(columnIndex, x, scaleOrLength);
  }

  @Override
  public void updateObject(String columnLabel, Object x) throws SQLException {
    this.resultado.updateObject(columnLabel, x);
  }

  @Override
  public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
    this.resultado.updateObject(columnLabel, x, scaleOrLength);
  }

  @Override
  public void updateRef(int columnIndex, Ref x) throws SQLException {
    this.resultado.updateRef(columnIndex, x);
  }

  @Override
  public void updateRef(String columnLabel, Ref x) throws SQLException {
    this.resultado.updateRef(columnLabel, x);
  }

  @Override
  public void updateRow() throws SQLException {
    this.resultado.updateRow();
  }

  @Override
  public void updateRowId(int columnIndex, RowId x) throws SQLException {
    this.resultado.updateRowId(columnIndex, x);
  }

  @Override
  public void updateRowId(String columnLabel, RowId x) throws SQLException {
    this.resultado.updateRowId(columnLabel, x);
  }

  @Override
  public void updateShort(int columnIndex, short x) throws SQLException {
    this.resultado.updateShort(columnIndex, x);
  }

  @Override
  public void updateShort(String columnLabel, short x) throws SQLException {
    this.resultado.updateShort(columnLabel, x);
  }

  @Override
  public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
    this.resultado.updateSQLXML(columnIndex, xmlObject);
  }

  @Override
  public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
    this.resultado.updateSQLXML(columnLabel, xmlObject);
  }

  @Override
  public void updateString(int columnIndex, String x) throws SQLException {
    this.resultado.updateString(columnIndex, x);
  }

  @Override
  public void updateString(String columnLabel, String x) throws SQLException {
    this.resultado.updateString(columnLabel, x);
  }

  @Override
  public void updateTime(int columnIndex, Time x) throws SQLException {
    this.resultado.updateTime(columnIndex, x);
  }

  @Override
  public void updateTime(String columnLabel, Time x) throws SQLException {
    this.resultado.updateTime(columnLabel, x);
  }

  @Override
  public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
    this.resultado.updateTimestamp(columnIndex, x);
  }

  @Override
  public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
    this.resultado.updateTimestamp(columnLabel, x);
  }

  @Override
  public boolean wasNull() throws SQLException {
    return this.resultado.wasNull();
  }

  // metodos herdados da interface Wrapper

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return this.resultado.isWrapperFor(iface);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    return this.resultado.unwrap(iface);
  }

  @Override
  public int hashCode() {
    int ret = super.hashCode();

    ret = 13 * ret + (this.comando == null ? 0 : this.comando.hashCode());
    ret = 13 * ret + (this.resultado == null ? 0 : this.resultado.hashCode());

    return ret;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;

    if (this == obj)
      return true;

    if (this.getClass() == obj.getClass()) {
      ResultSet rs = (ResultSet) obj;

      if (!super.equals(rs))
        return false;

      MeuResultSet mrs = (MeuResultSet) obj;

      if (!this.comando.equals(mrs.comando))
        return false;

      if (!this.resultado.equals(mrs.resultado))
        return false;

      return true;
    }

    return false;
  }

  @Override
  public String toString() {
    String ret = "Herdado: " + super.toString() + "\n";

    ret += "Comando...: " + this.comando;

    return ret;
  }

  // O metodo compareTo, que �, por vezes, obrigatorio, nao esta
  // sendo implementado porque, tendo dois objetos instanciados
  // desta classe, nao faria sentido pensar em qual deles eh o
  // maior ou em qual deles eh o menor.

  // Os metodos clone e construtor de copia, por vezes, obrigatorios,
  // nao estao sendo implementados porque, nao sao necessarios, ja
  // que esta classe nao possui metodos que alterem variaveis
  // declaradas (private ou protected).
}