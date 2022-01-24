package com.sks.hawkeye.util;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sks.hawkeye.dto.AdditionalEventInformation;
import com.sks.hawkeye.dto.BatStatPosition;
import com.sks.hawkeye.dto.Batsman;
import com.sks.hawkeye.dto.BatsmanPartner;
import com.sks.hawkeye.dto.BattingTeam;
import com.sks.hawkeye.dto.BouncePosition;
import com.sks.hawkeye.dto.Bowler;
import com.sks.hawkeye.dto.BowlerPartner;
import com.sks.hawkeye.dto.BowlingTeam;
import com.sks.hawkeye.dto.CreasePosition;
import com.sks.hawkeye.dto.Delivery;
import com.sks.hawkeye.dto.DeliveryNumber;
import com.sks.hawkeye.dto.FielderPosition;
import com.sks.hawkeye.dto.TourSnapShot;
import com.sks.hawkeye.dto.ImpactPosition;
import com.sks.hawkeye.dto.LandingPosition;
import com.sks.hawkeye.dto.Match;
import com.sks.hawkeye.dto.ReleasePosition;
import com.sks.hawkeye.dto.ScoringInformation;
import com.sks.hawkeye.dto.ShotInformation;
import com.sks.hawkeye.dto.StumpPosition;
import com.sks.hawkeye.dto.Trajectory;
import com.sks.hawkeye.dto.Wicket;
import com.sks.hawkeye.model.gameSnap.AdditionalEventInfoEntity;
import com.sks.hawkeye.model.gameSnap.BatStatPositionEntity;
import com.sks.hawkeye.model.gameSnap.PlayerEntity;
import com.sks.hawkeye.model.gameSnap.TeamEntity;
import com.sks.hawkeye.model.gameSnap.BouncePositionEntity;
import com.sks.hawkeye.model.gameSnap.CreasePositionEntity;
import com.sks.hawkeye.model.gameSnap.DeliveryEntity;
import com.sks.hawkeye.model.gameSnap.DeliveryNumberEntity;
import com.sks.hawkeye.model.gameSnap.FielderPositionEntity;
import com.sks.hawkeye.model.gameSnap.TourSnapShotEntity;
import com.sks.hawkeye.model.gameSnap.ImpactPositionEntity;
import com.sks.hawkeye.model.gameSnap.LandingPositionEntity;
import com.sks.hawkeye.model.gameSnap.MatchEntity;
import com.sks.hawkeye.model.gameSnap.ReleasePositionEntity;
import com.sks.hawkeye.model.gameSnap.ScoringInfoEntity;
import com.sks.hawkeye.model.gameSnap.ShotInfoEntity;
import com.sks.hawkeye.model.gameSnap.StumpPositionEntity;
import com.sks.hawkeye.model.gameSnap.TeamEntity;
import com.sks.hawkeye.model.gameSnap.TrajectoryEntity;
import com.sks.hawkeye.model.gameSnap.WicketEntity;
import com.sks.hawkeye.repository.GameSnapRepository;
import com.sks.hawkeye.repository.MatchRepository;
import com.sks.hawkeye.repository.PlayerRepository;
import com.sks.hawkeye.repository.TeamRepository;
import com.sks.hawkeye.response.TourSnapShotRes;

@Service 
public class GameSnapUtil {
	
	public TourSnapShotEntity prepare(TourSnapShot tourSnapShot) {
		return prepareGameSnapShotEntity(tourSnapShot);
	}

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	MatchRepository matchRepository;

	@Autowired
	GameSnapRepository gameSnapRepository;

	public TourSnapShotEntity prepare(TourSnapShotEntity tse, TourSnapShot tourSnapShot) {
		return prepareGameSnapShotEntity(tourSnapShot);
	}
	
	private TourSnapShotEntity prepareGameSnapShotEntity(TourSnapShot tss) {
		TourSnapShotEntity tsse = gameSnapRepository.findByTourName(tss.getTourName()).orElse(new TourSnapShotEntity());
		tsse.setTourName(tss.getTourName());
		tsse.setInternational(tss.getInternational());
		tsse.setCountry(tss.getCountry());
		tsse.setFormat(tss.getFormat());
		tsse.addMatch(prepare(tsse, tss.getMatch()));
		return tsse;
	}

	private MatchEntity prepare(TourSnapShotEntity gsse,Match m) {
		MatchEntity me = matchRepository.findByName(m.getName()).orElse(new MatchEntity(gsse));
		me.setName(m.getName());
		me.addParticipatingTeams(prepare(me, m.getBattingTeam()));
		me.addParticipatingTeams(prepare(me, m.getBowlingTeam()));
		me.addDelivery(prepare(me, m.getDelivery(),m));
		return me;
	}

	private TeamEntity prepare(MatchEntity me, BattingTeam bt) {
		TeamEntity bte=teamRepository.findByTeamName(bt.getName()).orElse( new TeamEntity(me));
		bte.setId(bt.getId());
		bte.setHome(bt.isHome());
		bte.setTeamName(bt.getName());
		bte.addPlayer(null);
		return bte;
	}

	private PlayerEntity prepare(TeamEntity bte, BatsmanPartner bp) {
		PlayerEntity bpe = playerRepository.findByPlayerId(bp.getId()).orElse( new PlayerEntity(bte));
		bpe.setPlayerId(bp.getId());
		bpe.setName(bp.getName());
		bpe.setRightHanded(bp.isRightHanded());
		return bpe;
	}

	private PlayerEntity prepare(TeamEntity bte, Batsman b) {
		PlayerEntity be = playerRepository.findByPlayerId(b.getId()).orElse( new PlayerEntity(bte));
		be.setPlayerId(b.getId());
		be.setName(b.getName());
		be.setRightHanded(b.isRightHanded());
		return be;
	}
	
	private PlayerEntity prepare(TeamEntity prepare, Bowler b) {
		PlayerEntity be =playerRepository.findByPlayerId(b.getId()).orElse( new PlayerEntity(prepare));
		be.setPlayerId(b.getId());
		be.setName(b.getName());
		be.setRightHanded(b.isRightHanded());
		return be;
	}

	private TeamEntity prepare(MatchEntity me, BowlingTeam bt) {
		TeamEntity bte = teamRepository.findByTeamName(bt.getName()).orElse( new TeamEntity(me));
		bte.setTeamName(bt.getName());
		bte.setHome(bt.isHome());
		return bte;
	}
	
	private DeliveryEntity prepare(MatchEntity me, Delivery d,Match m) {
		DeliveryEntity de = new DeliveryEntity(me);
		de.setAdditionalEventInformation(prepare(de, d.getAdditionalEventInformation()));
		de.setDeliveryNumber(prepare(de, d.getDeliveryNumber()));
		de.setDeliveryType(d.getDeliveryType());
		de.setFielderPosition(prepare(de, d.getFielderPosition()));
		de.setPavilionEnd(d.isPavilionEnd());
		de.setRound(d.isRound());
		de.setScoringInformation(prepare(de, d.getScoringInformation()));
		de.setShotInformation(prepare(de, d.getShotInformation()));
		de.setTimecode(d.getTimecode());
		de.setTrajectory(prepare(de, d.getTrajectory()));
		
		de.setBatsman(this.playerRepository.findById(m.getBattingTeam().getBatsman().getId()).orElse(prepare(prepare(me,m.getBattingTeam()),m.getBattingTeam().getBatsman())));
		de.setBatsmanPartner(playerRepository.findById(m.getBattingTeam().getBatsmanPartner().getId()).orElse(prepare(prepare(me,m.getBattingTeam()),m.getBattingTeam().getBatsmanPartner())));
		de.setBowler(playerRepository.findById(m.getBowlingTeam().getBowler().getId()).orElse(prepare(prepare(me,m.getBattingTeam()),m.getBowlingTeam().getBowler())));
		
		//de.setBatsman(prepare(prepare(me,m.getBattingTeam()),m.getBattingTeam().getBatsman()));
		//de.setBatsmanPartner(prepare(prepare(me,m.getBattingTeam()),m.getBattingTeam().getBatsmanPartner()));
		//de.setBowler(prepare(prepare(me,m.getBowlingTeam()),m.getBowlingTeam().getBowler()));
		//de.setBatsmanPartner(playerRepository.getById(m.getBattingTeam().getBatsmanPartner().getId()));
		//de.setBowler(playerRepository.getById(m.getBowlingTeam().getBowler().getId()));
		
		return de;
	}
	
	/*
	private BowlerEntity prepare(TeamEntity bte, Bowler b) {
		BowlerEntity be = new BowlerEntity(bte);
		be.setId(b.getId());
		be.setName(b.getName());
		be.setRightHanded(b.isRightHanded());
		be.setSpell(b.getSpell());
		return be;
	}
*/
	private TrajectoryEntity prepare(DeliveryEntity de, Trajectory t) {
		TrajectoryEntity te = new TrajectoryEntity(de);
		te.setBounceAboveStumps(t.isBounceAboveStumps());
		te.setBounceAngle(t.getBounceAngle());
		te.setCof(t.getCof());
		te.setCor(t.getCor());
		te.setDeviation(t.getDeviation());
		te.setDropAngle(t.getDropAngle());
		te.setHitStumps(t.getHitStumps());
		te.setInitialAngle(t.getInitialAngle());
		te.setLength(t.getLength());
		te.setOffBatAngle(t.getOffBatAngle());
		te.setOffBatSpeed(t.getOffBatSpeed());
		te.setPbr(t.getPbr());
		te.setReactionTimeToCrease(t.getReactionTimeToCrease());
		te.setReactionTimeToInterception(t.getReactionTimeToInterception());
		te.setRealDistance(t.getRealDistance());
		te.setReleaseSpeed(t.getReleaseSpeed());
		te.setSpinRate(t.getSpinRate());
		te.setSwing(t.getSwing());
		te.setTrajectoryData(t.getTrajectoryData());
		te.setBatStatPosition(prepare(te,t.getBatStatPosition()));
		te.setBouncePosition(prepare(te,t.getBouncePosition()));
		te.setCreasePosition(prepare(te,t.getCreasePosition()));
		te.setImpactPosition(prepare(te,t.getImpactPosition()));
		te.setLandingPosition(prepare(te,t.getLandingPosition()));
		te.setReleasePosition(prepare(te,t.getReleasePosition()));
		te.setStumpPosition(prepare(te,t.getStumpPosition()));
		
		return te;
	}

	private StumpPositionEntity prepare(TrajectoryEntity te, StumpPosition sp) {
		StumpPositionEntity spe = new StumpPositionEntity(te);
		spe.setX(sp.getX());
		spe.setY(sp.getY());
		spe.setZ(sp.getZ());
		return spe;
	}

	private ReleasePositionEntity prepare(TrajectoryEntity te, ReleasePosition rp) {
		ReleasePositionEntity rpe = new ReleasePositionEntity(te);
		rpe.setX(rp.getX());
		rpe.setY(rp.getY());
		rpe.setZ(rp.getZ());
		return rpe;
	}

	private LandingPositionEntity prepare(TrajectoryEntity te, LandingPosition lp) {
		LandingPositionEntity lpe = new LandingPositionEntity(te);
		lpe.setX(lp.getX());
		lpe.setY(lp.getY());
		lpe.setZ(lp.getZ());
		return lpe;
	}

	private ImpactPositionEntity prepare(TrajectoryEntity te, ImpactPosition ip) {
		ImpactPositionEntity ipe = new ImpactPositionEntity(te);
		ipe.setX(ip.getX());
		ipe.setY(ip.getY());
		ipe.setZ(ip.getZ());
		return ipe;
	}

	private CreasePositionEntity prepare(TrajectoryEntity te, CreasePosition cp) {
		CreasePositionEntity cpe = new CreasePositionEntity(te);
		cpe.setX(cp.getX());
		cpe.setY(cp.getY());
		cpe.setZ(cp.getZ());
		return cpe;
	}

	private BouncePositionEntity prepare(TrajectoryEntity te, BouncePosition bp) {
		BouncePositionEntity bpe = new BouncePositionEntity(te);
		bpe.setX(bp.getX());
		bpe.setY(bp.getY());
		bpe.setZ(bp.getZ());
		return bpe;
	}

	private BatStatPositionEntity prepare(TrajectoryEntity te, BatStatPosition bp) {
		BatStatPositionEntity bpe = new BatStatPositionEntity(te);
		bpe.setX(bp.getX());
		bpe.setY(bp.getY());
		return bpe;
	}

	private ShotInfoEntity prepare(DeliveryEntity de, ShotInformation si) {
		ShotInfoEntity sie = new ShotInfoEntity(de);
		sie.setBatsmanWeight( si.getBatsmanWeight());
		sie.setShotAttacked( si.getShotAttacked());
		sie.setShotPlayed( si.getShotPlayed());
		sie.setShotTypeAdditional( si.getShotTypeAdditional());

		return sie;
	}

	private ScoringInfoEntity prepare(DeliveryEntity de, ScoringInformation si) {
		ScoringInfoEntity sie = new ScoringInfoEntity(de);
		sie.setBoundary(si.isBoundary());
		sie.setExtrasScore(si.getExtrasScore());
		sie.setExtrasType(si.getExtrasType());
		sie.setOverthrowScore(si.isOverthrowScore());
		sie.setScore(si.getScore());
		sie.setWicket(preapare(sie, si.getWicket()));
		return sie;
	}

	private WicketEntity preapare(ScoringInfoEntity sie, Wicket w) {
		WicketEntity we = new WicketEntity(sie);
		we.setWicket(w.isWicket());
		we.setWicketsTaken(w.isWicketsTaken());
		we.setWicketType(w.getWicketType());
		return we;
	}

	private FielderPositionEntity prepare(DeliveryEntity de, FielderPosition fp) {
		FielderPositionEntity fpe = new FielderPositionEntity(de);
		fpe.setFirstSlip( fp.isFirstSlip());
		fpe.setSecondSlip( fp.isSecondSlip());
		fpe.setThirdSlip( fp.isThirdSlip());
		fpe.setFourthSlip( fp.isFourthSlip());
		fpe.setFifthSlip( fp.isFifthSlip());
		fpe.setBackwardsPoint( fp.isBackwardsPoint());
		fpe.setCover( fp.isCover());
		fpe.setCowCorner( fp.isCowCorner());
		fpe.setDeepBackwardsSquareLeg( fp.isDeepBackwardsSquareLeg());
		fpe.setDeepCover( fp.isDeepCover());
		fpe.setDeepExtraCover( fp.isDeepExtraCover());
		fpe.setDeepMidWicket( fp.isDeepMidWicket());
		fpe.setDeepPoint( fp.isDeepPoint());
		fpe.setDeepSquareLeg( fp.isDeepSquareLeg());
		fpe.setExtraCover( fp.isExtraCover());
		fpe.setFineLeg( fp.isFineLeg());
		fpe.setFlySlip( fp.isFlySlip());
		fpe.setGully( fp.isGully());
		fpe.setLegGully( fp.isLegGully());
		fpe.setLegSlip( fp.isLegSlip());
		fpe.setLongLeg( fp.isLongLeg());
		fpe.setLongOff( fp.isLongOff());
		fpe.setLongOn( fp.isLongOn());
		fpe.setMidWicket( fp.isMidWicket());
		fpe.setMidOff( fp.isMidOff());
		fpe.setMidOn( fp.isMidOn());
		fpe.setPoint( fp.isPoint());
		fpe.setShortExtraCover( fp.isShortExtraCover());
		fpe.setShortFineLeg( fp.isShortFineLeg());
		fpe.setShortLeg( fp.isShortLeg());
		fpe.setShortMidWicket( fp.isShortMidWicket());
		fpe.setSillyMidOff( fp.isSillyMidOff());
		fpe.setSillyPoint( fp.isSillyPoint());
		fpe.setSquareLeg( fp.isSquareLeg());
		fpe.setThirdMan( fp.isThirdMan());
		fpe.setWicketKeeper( fp.isWicketKeeper());
		return fpe;
	}

	private DeliveryNumberEntity prepare(DeliveryEntity de, DeliveryNumber dn) {
		DeliveryNumberEntity dne = new DeliveryNumberEntity(de);
		dne.setBall(dn.getBall());
		dne.setDay(dn.getDay());
		dne.setInnings(dn.getInnings());
		dne.setOver(dn.getOver());
		return dne;
	}

	private AdditionalEventInfoEntity prepare(DeliveryEntity de, AdditionalEventInformation ai) {
		AdditionalEventInfoEntity aie = new AdditionalEventInfoEntity(de);
		aie.setDropped(ai.isDropped());
		return aie;
	}

}

