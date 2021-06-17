package za.co.span.assessment.fixtures.utils.mapper;

import leaguerankingservice.consume.model.TeamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import za.co.span.assessment.fixtures.pojo.Team;

import java.util.List;

@Mapper
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    TeamDTO teaToTeamDTO(Team team);

    Team teamDTOToTeam(TeamDTO teamDTO);

    List<TeamDTO> mapToDTO(List<Team> teamList);

    List<Team> mapToPojo(List<TeamDTO> teamDTOList);

}
