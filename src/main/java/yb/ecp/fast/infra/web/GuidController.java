package yb.ecp.fast.infra.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yb.ecp.fast.infra.infra.ActionResult;
import yb.ecp.fast.infra.infra.BasicController;
import yb.ecp.fast.infra.service.GuidService;

@RestController
@RequestMapping({"/guid"})
public class GuidController
  extends BasicController
{
  @Autowired
  private GuidService guidService;
  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  
  @RequestMapping(value={"/number"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ActionResult number()
  {
    return actionResult(Long.valueOf(this.guidService.nextId()));
  }
  
  @ApiOperation("redis示例接口，获取redis中的某个key的value")
  @RequestMapping(value={"/redisDemo"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String redisDemo(String key)
  {
    return (String)this.stringRedisTemplate.opsForValue().get(key);
  }
  
  @RequestMapping(value={"/text"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ActionResult text()
  {
    return actionResult(Long.toString(this.guidService.nextId()));
  }
  
  @RequestMapping(value={"/next"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ActionResult nextId()
  {
    return actionResult(Long.valueOf(this.guidService.nextId()));
  }
}
