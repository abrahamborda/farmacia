<<<<<<< HEAD
package org.abc.mapper;

import java.util.List;
import org.abc.domain.Categoria;
import org.abc.domain.CategoriaExample;
import org.apache.ibatis.annotations.Param;

public interface CategoriaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    long countByExample(CategoriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int deleteByExample(CategoriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int deleteByPrimaryKey(Integer idCategoria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int insert(Categoria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int insertSelective(Categoria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    List<Categoria> selectByExample(CategoriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    Categoria selectByPrimaryKey(Integer idCategoria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int updateByExampleSelective(@Param("record") Categoria record, @Param("example") CategoriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int updateByExample(@Param("record") Categoria record, @Param("example") CategoriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int updateByPrimaryKeySelective(Categoria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int updateByPrimaryKey(Categoria record);
=======
package org.abc.mapper;

import java.util.List;
import org.abc.domain.Categoria;
import org.abc.domain.CategoriaExample;
import org.apache.ibatis.annotations.Param;

public interface CategoriaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    long countByExample(CategoriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int deleteByExample(CategoriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int deleteByPrimaryKey(Integer idCategoria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int insert(Categoria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int insertSelective(Categoria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    List<Categoria> selectByExample(CategoriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    Categoria selectByPrimaryKey(Integer idCategoria);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int updateByExampleSelective(@Param("record") Categoria record, @Param("example") CategoriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int updateByExample(@Param("record") Categoria record, @Param("example") CategoriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int updateByPrimaryKeySelective(Categoria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    int updateByPrimaryKey(Categoria record);
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
}