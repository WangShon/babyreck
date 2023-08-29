package vn.edu.vnua.toiec.usecases;

import org.springframework.data.jpa.domain.Specification;
import vn.edu.vnua.toiec.data.entities.Part;
import vn.edu.vnua.toiec.presentation.model.PartRequest;
import vn.edu.vnua.toiec.presentation.model.PartResponse;

import java.util.List;

public interface PartService {
    Part createPart(PartRequest partRequest);

    Part updatePart(PartRequest partRequest);

    Part delete(PartResponse partResponse);

    List<PartResponse> getAllParts();

    List<PartResponse> getAllNumberPart();

    List<PartResponse> getAllNumberPartOne();

    List<PartResponse> getAllNumberPartTwo();

    List<PartResponse> getAllNumberPartThree();

    List<PartResponse> getAllNumberPartFour();

    List<PartResponse> getAllNumberPartFive();

    List<PartResponse> getAllNumberPartSix();

    List<PartResponse> getAllNumberPartSeven();

    Specification<Part> searchAllPart(String keyword);

}
