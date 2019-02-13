package yb.ecp.fast.infra.infra;

public enum ErrorCode
{
  Success(0, "操作成功"),  Failure(1, "操作失败"),  NeedLogin(2, "用户没有登录"),  UnExceptedError(3, "未知的错误发生"),  IllegalArument(4, "参数错误"),  SQLIntegrityConstraintViolation(5, "违反完整性约束"),  NoAuthorization(6, "没有权限执行此操作"),  CheckLoginFailure(7, "用户不存在或者密码错误"),  UserNameExists(8, "登录名称已存在"),  RoleNameExists(9, "角色名已存在"),  RoleIsUsed(10, "角色已经被使用"),  UserLocked(11, "用户被锁定"),  OldPwdNotRight(12, "原密码不正确"),  NewPwdNotMatchConfirmPwd(13, "新密码与确认密码不一致"),  SqlSyntaxError(14, "数据库执行异常"),  YourErrorCodeGoesHere(1000, "你的失败码请在后面定义");
  
  private String desc;
  private int code;
  
  private ErrorCode(int code, String desc)
  {
    this.desc = desc;
    this.code = code;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public int getCode()
  {
    return this.code;
  }
}
