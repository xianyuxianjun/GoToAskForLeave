import com.chenxianyu.model.dto.RegisterDto;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    /**
     * 处理注册请求
     * @param registerDto 注册信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public Reslut Register(@RequestBody RegisterDto registerDto){
        // 调用注册服务
        return registerService.segister(registerDto);
    }
}