package org.abc.mapper;

import java.util.List;
import org.abc.domain.Laboratorio;
import org.abc.domain.LaboratorioExample;
import org.apache.ibatis.annotations.Param;

public interface LaboratorioMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	long countByExample(LaboratorioExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	int deleteByExample(LaboratorioExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	int deleteByPrimaryKey(Integer idLaboratorio);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	int insert(Laboratorio record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	int insertSelective(Laboratorio record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	List<Laboratorio> selectByExample(LaboratorioExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	Laboratorio selectByPrimaryKey(Integer idLaboratorio);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	int updateByExampleSelective(@Param("record") Laboratorio record, @Param("example") LaboratorioExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	int updateByExample(@Param("record") Laboratorio record, @Param("example") LaboratorioExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	int updateByPrimaryKeySelective(Laboratorio record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.laboratorio
	 * @mbg.generated  Tue Sep 15 17:08:00 BOT 2020
	 */
	int updateByPrimaryKey(Laboratorio record);
}