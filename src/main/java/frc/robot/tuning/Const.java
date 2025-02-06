package frc.robot.tuning;

public class Const<T> {

  private String m_key;
  private T m_value;

  public Const(String key, T value) {
    m_key = key;
    m_value = value;
  }

  public String key() {
    return m_key;
  }

  public T val() {
    return m_value;
  }

}