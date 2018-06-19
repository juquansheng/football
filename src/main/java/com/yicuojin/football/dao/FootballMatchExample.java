package com.yicuojin.football.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FootballMatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FootballMatchExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTeamaIsNull() {
            addCriterion("TeamA is null");
            return (Criteria) this;
        }

        public Criteria andTeamaIsNotNull() {
            addCriterion("TeamA is not null");
            return (Criteria) this;
        }

        public Criteria andTeamaEqualTo(Integer value) {
            addCriterion("TeamA =", value, "teama");
            return (Criteria) this;
        }

        public Criteria andTeamaNotEqualTo(Integer value) {
            addCriterion("TeamA <>", value, "teama");
            return (Criteria) this;
        }

        public Criteria andTeamaGreaterThan(Integer value) {
            addCriterion("TeamA >", value, "teama");
            return (Criteria) this;
        }

        public Criteria andTeamaGreaterThanOrEqualTo(Integer value) {
            addCriterion("TeamA >=", value, "teama");
            return (Criteria) this;
        }

        public Criteria andTeamaLessThan(Integer value) {
            addCriterion("TeamA <", value, "teama");
            return (Criteria) this;
        }

        public Criteria andTeamaLessThanOrEqualTo(Integer value) {
            addCriterion("TeamA <=", value, "teama");
            return (Criteria) this;
        }

        public Criteria andTeamaIn(List<Integer> values) {
            addCriterion("TeamA in", values, "teama");
            return (Criteria) this;
        }

        public Criteria andTeamaNotIn(List<Integer> values) {
            addCriterion("TeamA not in", values, "teama");
            return (Criteria) this;
        }

        public Criteria andTeamaBetween(Integer value1, Integer value2) {
            addCriterion("TeamA between", value1, value2, "teama");
            return (Criteria) this;
        }

        public Criteria andTeamaNotBetween(Integer value1, Integer value2) {
            addCriterion("TeamA not between", value1, value2, "teama");
            return (Criteria) this;
        }

        public Criteria andTeambIsNull() {
            addCriterion("TeamB is null");
            return (Criteria) this;
        }

        public Criteria andTeambIsNotNull() {
            addCriterion("TeamB is not null");
            return (Criteria) this;
        }

        public Criteria andTeambEqualTo(Integer value) {
            addCriterion("TeamB =", value, "teamb");
            return (Criteria) this;
        }

        public Criteria andTeambNotEqualTo(Integer value) {
            addCriterion("TeamB <>", value, "teamb");
            return (Criteria) this;
        }

        public Criteria andTeambGreaterThan(Integer value) {
            addCriterion("TeamB >", value, "teamb");
            return (Criteria) this;
        }

        public Criteria andTeambGreaterThanOrEqualTo(Integer value) {
            addCriterion("TeamB >=", value, "teamb");
            return (Criteria) this;
        }

        public Criteria andTeambLessThan(Integer value) {
            addCriterion("TeamB <", value, "teamb");
            return (Criteria) this;
        }

        public Criteria andTeambLessThanOrEqualTo(Integer value) {
            addCriterion("TeamB <=", value, "teamb");
            return (Criteria) this;
        }

        public Criteria andTeambIn(List<Integer> values) {
            addCriterion("TeamB in", values, "teamb");
            return (Criteria) this;
        }

        public Criteria andTeambNotIn(List<Integer> values) {
            addCriterion("TeamB not in", values, "teamb");
            return (Criteria) this;
        }

        public Criteria andTeambBetween(Integer value1, Integer value2) {
            addCriterion("TeamB between", value1, value2, "teamb");
            return (Criteria) this;
        }

        public Criteria andTeambNotBetween(Integer value1, Integer value2) {
            addCriterion("TeamB not between", value1, value2, "teamb");
            return (Criteria) this;
        }

        public Criteria andPrateIsNull() {
            addCriterion("Prate is null");
            return (Criteria) this;
        }

        public Criteria andPrateIsNotNull() {
            addCriterion("Prate is not null");
            return (Criteria) this;
        }

        public Criteria andPrateEqualTo(BigDecimal value) {
            addCriterion("Prate =", value, "prate");
            return (Criteria) this;
        }

        public Criteria andPrateNotEqualTo(BigDecimal value) {
            addCriterion("Prate <>", value, "prate");
            return (Criteria) this;
        }

        public Criteria andPrateGreaterThan(BigDecimal value) {
            addCriterion("Prate >", value, "prate");
            return (Criteria) this;
        }

        public Criteria andPrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Prate >=", value, "prate");
            return (Criteria) this;
        }

        public Criteria andPrateLessThan(BigDecimal value) {
            addCriterion("Prate <", value, "prate");
            return (Criteria) this;
        }

        public Criteria andPrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Prate <=", value, "prate");
            return (Criteria) this;
        }

        public Criteria andPrateIn(List<BigDecimal> values) {
            addCriterion("Prate in", values, "prate");
            return (Criteria) this;
        }

        public Criteria andPrateNotIn(List<BigDecimal> values) {
            addCriterion("Prate not in", values, "prate");
            return (Criteria) this;
        }

        public Criteria andPrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Prate between", value1, value2, "prate");
            return (Criteria) this;
        }

        public Criteria andPrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Prate not between", value1, value2, "prate");
            return (Criteria) this;
        }

        public Criteria andBrateIsNull() {
            addCriterion("Brate is null");
            return (Criteria) this;
        }

        public Criteria andBrateIsNotNull() {
            addCriterion("Brate is not null");
            return (Criteria) this;
        }

        public Criteria andBrateEqualTo(BigDecimal value) {
            addCriterion("Brate =", value, "brate");
            return (Criteria) this;
        }

        public Criteria andBrateNotEqualTo(BigDecimal value) {
            addCriterion("Brate <>", value, "brate");
            return (Criteria) this;
        }

        public Criteria andBrateGreaterThan(BigDecimal value) {
            addCriterion("Brate >", value, "brate");
            return (Criteria) this;
        }

        public Criteria andBrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Brate >=", value, "brate");
            return (Criteria) this;
        }

        public Criteria andBrateLessThan(BigDecimal value) {
            addCriterion("Brate <", value, "brate");
            return (Criteria) this;
        }

        public Criteria andBrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Brate <=", value, "brate");
            return (Criteria) this;
        }

        public Criteria andBrateIn(List<BigDecimal> values) {
            addCriterion("Brate in", values, "brate");
            return (Criteria) this;
        }

        public Criteria andBrateNotIn(List<BigDecimal> values) {
            addCriterion("Brate not in", values, "brate");
            return (Criteria) this;
        }

        public Criteria andBrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Brate between", value1, value2, "brate");
            return (Criteria) this;
        }

        public Criteria andBrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Brate not between", value1, value2, "brate");
            return (Criteria) this;
        }

        public Criteria andArateIsNull() {
            addCriterion("Arate is null");
            return (Criteria) this;
        }

        public Criteria andArateIsNotNull() {
            addCriterion("Arate is not null");
            return (Criteria) this;
        }

        public Criteria andArateEqualTo(BigDecimal value) {
            addCriterion("Arate =", value, "arate");
            return (Criteria) this;
        }

        public Criteria andArateNotEqualTo(BigDecimal value) {
            addCriterion("Arate <>", value, "arate");
            return (Criteria) this;
        }

        public Criteria andArateGreaterThan(BigDecimal value) {
            addCriterion("Arate >", value, "arate");
            return (Criteria) this;
        }

        public Criteria andArateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Arate >=", value, "arate");
            return (Criteria) this;
        }

        public Criteria andArateLessThan(BigDecimal value) {
            addCriterion("Arate <", value, "arate");
            return (Criteria) this;
        }

        public Criteria andArateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Arate <=", value, "arate");
            return (Criteria) this;
        }

        public Criteria andArateIn(List<BigDecimal> values) {
            addCriterion("Arate in", values, "arate");
            return (Criteria) this;
        }

        public Criteria andArateNotIn(List<BigDecimal> values) {
            addCriterion("Arate not in", values, "arate");
            return (Criteria) this;
        }

        public Criteria andArateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Arate between", value1, value2, "arate");
            return (Criteria) this;
        }

        public Criteria andArateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Arate not between", value1, value2, "arate");
            return (Criteria) this;
        }

        public Criteria andScoreaIsNull() {
            addCriterion("ScoreA is null");
            return (Criteria) this;
        }

        public Criteria andScoreaIsNotNull() {
            addCriterion("ScoreA is not null");
            return (Criteria) this;
        }

        public Criteria andScoreaEqualTo(Integer value) {
            addCriterion("ScoreA =", value, "scorea");
            return (Criteria) this;
        }

        public Criteria andScoreaNotEqualTo(Integer value) {
            addCriterion("ScoreA <>", value, "scorea");
            return (Criteria) this;
        }

        public Criteria andScoreaGreaterThan(Integer value) {
            addCriterion("ScoreA >", value, "scorea");
            return (Criteria) this;
        }

        public Criteria andScoreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("ScoreA >=", value, "scorea");
            return (Criteria) this;
        }

        public Criteria andScoreaLessThan(Integer value) {
            addCriterion("ScoreA <", value, "scorea");
            return (Criteria) this;
        }

        public Criteria andScoreaLessThanOrEqualTo(Integer value) {
            addCriterion("ScoreA <=", value, "scorea");
            return (Criteria) this;
        }

        public Criteria andScoreaIn(List<Integer> values) {
            addCriterion("ScoreA in", values, "scorea");
            return (Criteria) this;
        }

        public Criteria andScoreaNotIn(List<Integer> values) {
            addCriterion("ScoreA not in", values, "scorea");
            return (Criteria) this;
        }

        public Criteria andScoreaBetween(Integer value1, Integer value2) {
            addCriterion("ScoreA between", value1, value2, "scorea");
            return (Criteria) this;
        }

        public Criteria andScoreaNotBetween(Integer value1, Integer value2) {
            addCriterion("ScoreA not between", value1, value2, "scorea");
            return (Criteria) this;
        }

        public Criteria andScorebIsNull() {
            addCriterion("ScoreB is null");
            return (Criteria) this;
        }

        public Criteria andScorebIsNotNull() {
            addCriterion("ScoreB is not null");
            return (Criteria) this;
        }

        public Criteria andScorebEqualTo(Integer value) {
            addCriterion("ScoreB =", value, "scoreb");
            return (Criteria) this;
        }

        public Criteria andScorebNotEqualTo(Integer value) {
            addCriterion("ScoreB <>", value, "scoreb");
            return (Criteria) this;
        }

        public Criteria andScorebGreaterThan(Integer value) {
            addCriterion("ScoreB >", value, "scoreb");
            return (Criteria) this;
        }

        public Criteria andScorebGreaterThanOrEqualTo(Integer value) {
            addCriterion("ScoreB >=", value, "scoreb");
            return (Criteria) this;
        }

        public Criteria andScorebLessThan(Integer value) {
            addCriterion("ScoreB <", value, "scoreb");
            return (Criteria) this;
        }

        public Criteria andScorebLessThanOrEqualTo(Integer value) {
            addCriterion("ScoreB <=", value, "scoreb");
            return (Criteria) this;
        }

        public Criteria andScorebIn(List<Integer> values) {
            addCriterion("ScoreB in", values, "scoreb");
            return (Criteria) this;
        }

        public Criteria andScorebNotIn(List<Integer> values) {
            addCriterion("ScoreB not in", values, "scoreb");
            return (Criteria) this;
        }

        public Criteria andScorebBetween(Integer value1, Integer value2) {
            addCriterion("ScoreB between", value1, value2, "scoreb");
            return (Criteria) this;
        }

        public Criteria andScorebNotBetween(Integer value1, Integer value2) {
            addCriterion("ScoreB not between", value1, value2, "scoreb");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(Integer value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(Integer value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(Integer value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(Integer value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(Integer value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<Integer> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<Integer> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(Integer value1, Integer value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(Integer value1, Integer value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUptetimeIsNull() {
            addCriterion("UpteTime is null");
            return (Criteria) this;
        }

        public Criteria andUptetimeIsNotNull() {
            addCriterion("UpteTime is not null");
            return (Criteria) this;
        }

        public Criteria andUptetimeEqualTo(Date value) {
            addCriterion("UpteTime =", value, "uptetime");
            return (Criteria) this;
        }

        public Criteria andUptetimeNotEqualTo(Date value) {
            addCriterion("UpteTime <>", value, "uptetime");
            return (Criteria) this;
        }

        public Criteria andUptetimeGreaterThan(Date value) {
            addCriterion("UpteTime >", value, "uptetime");
            return (Criteria) this;
        }

        public Criteria andUptetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpteTime >=", value, "uptetime");
            return (Criteria) this;
        }

        public Criteria andUptetimeLessThan(Date value) {
            addCriterion("UpteTime <", value, "uptetime");
            return (Criteria) this;
        }

        public Criteria andUptetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpteTime <=", value, "uptetime");
            return (Criteria) this;
        }

        public Criteria andUptetimeIn(List<Date> values) {
            addCriterion("UpteTime in", values, "uptetime");
            return (Criteria) this;
        }

        public Criteria andUptetimeNotIn(List<Date> values) {
            addCriterion("UpteTime not in", values, "uptetime");
            return (Criteria) this;
        }

        public Criteria andUptetimeBetween(Date value1, Date value2) {
            addCriterion("UpteTime between", value1, value2, "uptetime");
            return (Criteria) this;
        }

        public Criteria andUptetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpteTime not between", value1, value2, "uptetime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("StartTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("StartTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("StartTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("StartTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("StartTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("StartTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("StartTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("StartTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("StartTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("StartTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("StartTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("StartTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("EndTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("EndTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("EndTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("EndTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("EndTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EndTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("EndTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("EndTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("EndTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("EndTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("EndTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("EndTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}