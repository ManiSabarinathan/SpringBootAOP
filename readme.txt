Spring Boot with AOP 
@PointCut
@ProceddingJointPoint
StopWatch stopwatch = new StopWatch();
stopwatch.start()
Object object = proceddingjointpoint.proceed()
stopwatch.stop()
stopwatch.getTimeMills()
