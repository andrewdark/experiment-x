package ua.pp.darknsoft.services.taskReview;

import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;

import java.io.IOException;

public interface TaskReviewService {
    void review(String code, Long taskId) throws DockerCertificateException, DockerException, InterruptedException, IOException;
}
