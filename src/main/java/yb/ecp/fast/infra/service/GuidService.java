package yb.ecp.fast.infra.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import yb.ecp.fast.infra.algorithm.SnowflakeIdWorker;

@Service
public class GuidService
{
  @Value("${fast.guid.datacenter-id}")
  private int datacenterId;
  @Value("${fast.guid.worker-id}")
  private int workerId;
  private SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(this.workerId, this.datacenterId);
  
  public long nextId()
  {
    return this.snowflakeIdWorker.nextId();
  }
}
