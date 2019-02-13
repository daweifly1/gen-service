package yb.ecp.fast.infra.infra;

import javax.servlet.http.HttpServletRequest;

public class BasicController
{
  public <T> ActionResult<T> actionResult(T value)
  {
    ErrorCode a = ErrorCode.Success;
    return actionResult(a, value);
  }
  
  public String getUserId(HttpServletRequest request)
  {
    return request.getHeader("x-user-id");
  }
  
  public ActionResult actionResult(ErrorCode code)
  {
    return actionResult(code, null);
  }
  
  public <T> ActionResult<T> actionResult(ErrorCode code, T value)
  {
    return new ActionResult(code.getCode(), code.getDesc(), value);
  }
}
