package springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GetParaController {

    @Autowired
    private RestTemplate restTemplate;
    private Double pv1;
    private Double d;
    private Double T;
    private String result1;
    private String result2;
    private int num=0;
    private String name="7";
    @GetMapping("/getpv1")
    public String getpv1() {
//        if(++num>74){  try {
//            Thread.sleep(3);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }}

        try {
            Thread.sleep(0);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        result1=restTemplate.getForObject("http://traction-rope-basic-parameter"+ "/getd?name="+name ,String.class);
        d=new Double(result1);
        result2=restTemplate.getForObject("http://traction-rope-T-calculate" + "/getT?name="+name,String.class);
        T=new Double(result2);
        System.out.println(d);
        System.out.println(T);
        double degrees = 90.0;
        double radians = Math.toRadians(degrees);
        double ns = 10;
        double D1 = 1;

        pv1=T/(ns*d*D1)*(4.5/Math.sin(radians));
        System.out.println("pv1: "+pv1);
        return pv1+"";

    }
    @GetMapping("/test")
    public String test() throws InterruptedException {

        return "7";
    }


}
