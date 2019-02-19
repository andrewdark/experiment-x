package ua.pp.darknsoft.services.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.darknsoft.dto.TestTO;
import ua.pp.darknsoft.repositories.TestsRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TestsServiceImpl implements TestsService {
    @Autowired
    TestsRepository testsRepository;

    @Override
    public Collection<TestTO> getTests(Long taskId) {
        return testsRepository
                .findByTask_Id(taskId)
                .stream()
                .map(test -> new TestTO()
                          .setName(test.getName())
                          .setContent(test.getContent()))
                .collect(Collectors.toList());
    }
}
