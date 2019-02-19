package ua.pp.darknsoft.services.taskReview;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.LogStream;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;
import com.spotify.docker.client.messages.ExecCreation;
import com.spotify.docker.client.messages.HostConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.pp.darknsoft.dto.TestTO;
import ua.pp.darknsoft.services.errors.CompilationFailedException;
import ua.pp.darknsoft.services.tests.TestsService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class TaskReviewServiceImpl implements TaskReviewService {

    @Value("${docker.client.task.volume}")
    private String taskVolume;

    @Value("${docker.client.tests.volume}")
    private String testsVolume;

    @Value("${docker.client.task.source.path}")
    private String taskSourcePath;

    @Value("${docker.host.junit.jar}")
    private String hostVolume;


    @Autowired
    TestsService testsService;


    @Override
    public void review(String code, Long taskId) throws DockerCertificateException, DockerException, InterruptedException, IOException {


    }

    private static void cleanUp(DockerClient docker, String id) throws DockerException, InterruptedException {
        docker.stopContainer(id, 1);
        docker.removeContainer(id);
        docker.close();
    }
}
