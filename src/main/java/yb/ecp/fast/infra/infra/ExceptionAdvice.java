package yb.ecp.fast.infra.infra;

import java.sql.SQLIntegrityConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

public class ExceptionAdvice
{
  private Logger logger = LoggerFactory.getLogger(getClass());

  @ExceptionHandler({Exception.class})
  @ResponseBody
  public ActionResult processExcption(NativeWebRequest request, Exception e)
  {
    this.logger.error("这个是一个伟大的异常", e);
    ErrorCode code = ErrorCode.UnExceptedError;

    return new ActionResult(code.getCode(), code.getDesc(), null);
  }

  @ExceptionHandler({IllegalArgumentException.class})
  @ResponseBody
  public ActionResult processIllegalArumentExcption(NativeWebRequest request, IllegalArgumentException e)
  {
    this.logger.error("这个是一个伟大的异常", e);
    ErrorCode code = ErrorCode.IllegalArument;

    return new ActionResult(code.getCode(), code.getDesc(), null);
  }

  @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
  @ResponseBody
  public ActionResult processSQLIntegrityConstraintViolationException(NativeWebRequest request, IllegalArgumentException e)
  {
    this.logger.error("这个是一个伟大的异常", e);
    ErrorCode code = ErrorCode.SQLIntegrityConstraintViolation;
    return new ActionResult(code.getCode(), code.getDesc(), null);
  }
}
