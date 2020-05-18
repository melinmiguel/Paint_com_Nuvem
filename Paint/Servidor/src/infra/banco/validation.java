package src.infra.banco;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validation {

  public boolean IsEmailValid(String email) {
    Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
    Matcher m = p.matcher(email);
    if (m.find()) {
      return true;
    } else {
      return false;
    }

  }
}
