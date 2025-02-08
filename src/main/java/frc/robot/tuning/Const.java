package frc.robot.tuning;

public class Const<T> {

  private String m_key;
  private T m_value;
  private boolean m_tuneable = false;

  public Const(String key, T value, boolean tunable) {
    m_key = key;
    m_value = value;
    m_tuneable = tunable;
  }

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

  public boolean tunable() {
    return m_tuneable;
  }

}