package ${packageName}.controller;

import ${CommonUtilPackageName}.result.Result;
import ${CommonMinioPackageName}.service.FileStorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/files")
public class FileController {


    @Autowired
    private  FileStorageService fileStorageService;

    @GetMapping("createBucket")
    public Result createBucket(@RequestParam("bucketName") String bucketName){
        Boolean aBoolean = fileStorageService.makeBucket(bucketName);
        if(aBoolean){
            return Result.ok();
        }
        return Result.fail();
    }

    /**
     * 上传图片文件
     * @param prefix 文件前缀
     * @param file 文件对象
     * @return 文件的URL路径
     */
    @PostMapping("/upload/image")
    public ResponseEntity<String> uploadImageFile(@RequestParam("prefix") String prefix,
                                                  @RequestParam("file") MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            String imageUrl = fileStorageService.uploadImgFile(prefix, filename, file.getInputStream());
            return ResponseEntity.ok(imageUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传图片失败。");
        }
    }

    /**
     * 上传HTML文件
     * @param prefix 文件前缀
     * @param file 文件对象
     * @return 文件的URL路径
     */
    @PostMapping("/upload/html")
    public ResponseEntity<String> uploadHtmlFile(@RequestParam("prefix") String prefix,
                                                 @RequestParam("file") MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            String htmlUrl = fileStorageService.uploadHtmlFile(prefix, filename, file.getInputStream());
            return ResponseEntity.ok(htmlUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传HTML文件失败。");
        }
    }

//    /**
//     * 下载文件
//     * @param pathUrl 文件的URL路径
//     * @return 文件的字节数组
//     */
//    @GetMapping("/download")
//    public ResponseEntity<byte[]> downloadFile(@RequestParam("pathUrl") String pathUrl) {
//        try {
//            byte[] fileBytes = fileStorageService.downLoadFile(pathUrl);
//            return ResponseEntity.ok(fileBytes);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }


    /**
     * 下载文件
     * @param pathUrl 文件的URL路径
     * @return 文件的字节数组
     * 此接口已经设置响应头 在浏览器上直接请求就会下载对应的文件   如果只想单纯的返回二进制流就使用上面的接口
     */
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam("pathUrl") String pathUrl) {
        try {
            byte[] fileBytes = fileStorageService.downLoadFile(pathUrl);

            // 获取文件名（可以根据需要进行修改）
            String filename = FilenameUtils.getName(pathUrl);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    /**
     * 删除文件
     * @param pathUrl 文件的URL路径
     * @return 成功或失败信息
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFile(@RequestParam("pathUrl") String pathUrl) {
        try {
            fileStorageService.delete(pathUrl);
            return ResponseEntity.ok("文件删除成功。");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件删除失败。");
        }
    }
}
