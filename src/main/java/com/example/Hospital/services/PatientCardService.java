package com.example.Hospital.services;

import com.example.Hospital.domain.Contract;
import com.example.Hospital.domain.PatientCard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PatientCardService {
    private final List<PatientCard> patientCardList = new ArrayList<>();
    private  long ID=0;
    {
        patientCardList.add(new PatientCard(
                ++ID,
                "Смирнов",
                "Олег",
                "Андреевич",
                "муж",
                "12.21.2001",
                "89202328765",
                "3124334455"
                //new ArrayList<>()
        ));

        patientCardList.add(new PatientCard(
                ++ID,
                "Петров",
                "Дмитрий",
                "Андреевич",
                "муж",
                "09.21.2012",
                "89202328765",
                "3124334455"
                //new ArrayList<>()
        ));
    }

    public List<PatientCard> list(){
        return patientCardList;
    }

    public void savePatientCard(PatientCard patientCard){
        patientCard.setId(++ID);
        patientCardList.add(patientCard);
    }
    public void deleteProduct(Long id){
        patientCardList.removeIf(patientCard -> Objects.equals(patientCard.getId(), id));
    }

    public PatientCard getPatientCardById(Long id) {
        for(PatientCard patientCard:patientCardList){
            if(Objects.equals(patientCard.getId(), id))
                return  patientCard;
        }
        return null;
    }
}
//<b>Список договоров:</b>${patientCard.contractList}<br>
//<input type="submit" value="Добавить пациента">