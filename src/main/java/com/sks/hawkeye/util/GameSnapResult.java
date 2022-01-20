package com.sks.hawkeye.util;

import com.sks.hawkeye.model.gameSnap.*;
import com.sks.hawkeye.response.*;

public class GameSnapResult {

	private static GameSnapResult _instance = new GameSnapResult();

	public static TourSnapShotRes prepare(TourSnapShotEntity tourSnap) {
		return _instance.prepareGameSnapShot(tourSnap);
	}
	
	public static BattingTeam  prepareBattingTeam(BattingTeamEntity battingTeam) {
		return _instance.prepare(battingTeam);
	}
	
	public static BowlingTeam  prepareBowlingTeam(BowlingTeamEntity bowlingTeam) {
		return _instance.prepare(bowlingTeam);
	}
	
	public static Match prepareMatch(MatchEntity matchEntity) {
		return _instance.prepare(matchEntity);
	}
	

	private TourSnapShotRes prepareGameSnapShot(TourSnapShotEntity tourSnap) {
		TourSnapShotRes tss = new TourSnapShotRes();
		if(tourSnap != null) {
			tss.setTourName(tourSnap.getTourName());
			tss.setInternational(tourSnap.getInternational());
			tss.setCountry(tourSnap.getCountry());
			tss.setFormat(tourSnap.getFormat());
			for (MatchEntity m : tourSnap.getListMatch()) {
				tss.addMatch(prepare(m));
			}			
		}
		return tss;
	}
	
	private Match prepare(MatchEntity m) {
		Match me = new Match();
		me.setName(m.getName());
//		me.addBattingTeam(prepare(m.getBattingTeam()));
//		me.addBowlingTeam(prepare(m.getBowlingTeam()));
		for(BattingTeamEntity bte : m.getBattingTeam()) {
			me.addBattingTeam(prepare(bte));
		}
		for(BowlingTeamEntity bwte : m.getBowlingTeam()) {
			me.addBowlingTeam(prepare(bwte));
		}
		for (DeliveryEntity de : m.getListDelivery()) {
			me.addDelivery(prepare(de));
		}
		return me;
	}
	
	private Delivery prepare(DeliveryEntity de) {
		Delivery d = new Delivery();
		d.setAdditionalEventInformation(prepare( de.getAdditionalEventInformation()));
		d.setDeliveryNumber(prepare( de.getDeliveryNumber()));
		d.setDeliveryType(de.getDeliveryType());
		d.setFielderPosition(prepare( de.getFielderPosition()));
		d.setPavilionEnd(de.isPavilionEnd());
		d.setRound(de.isRound());
		d.setScoringInformation(prepare( de.getScoringInformation()));
		d.setShotInformation(prepare( de.getShotInformation()));
		d.setTimecode(de.getTimecode());
		d.setTrajectory(prepare( de.getTrajectory()));
		return d;
	}

	private BattingTeam prepare(BattingTeamEntity bt) {
		BattingTeam bte = new BattingTeam();
		bte.setId(bt.getId());
		bte.setBatsman(prepare( bt.getBatsman()));
		bte.setBatsmanPartner(prepare( bt.getBatsmanPartner()));
		bte.setHome(bt.isHome());
		bte.setName(bt.getName());
		return bte;
	}

	private BatsmanPartner prepare(BatsmanPartnerEntity bp) {
		BatsmanPartner bpe = new BatsmanPartner();
		bpe.setId(bp.getId());
		bpe.setName(bp.getName());
		bpe.setRightHanded(bp.isRightHanded());
		return bpe;
	}

	private Batsman prepare(BatsmanEntity b) {
		Batsman be = new Batsman();
		be.setId(b.getId());
		be.setName(b.getName());
		be.setRightHanded(b.isRightHanded());
		return be;
	}
	private BowlingTeam prepare(BowlingTeamEntity bt) {
		BowlingTeam bte = new BowlingTeam();
		bte.setName(bt.getName());
		bte.setHome(bt.isHome());
		bte.setBowler(prepare(bt.getBowler()));
		bte.setBowlerPartner(prepare(bt.getBowlerPartner()));
		
		return bte;
	}
	
	
	private BowlerPartner prepare(BowlerPartnerEntity bp) {
		BowlerPartner bpe = new BowlerPartner();
		bpe.setId(bp.getId());
		bpe.setName(bp.getName());
		bpe.setRightHanded(bp.isRightHanded());
		return bpe;
	}

	private Bowler prepare(BowlerEntity b) {
		Bowler be = new Bowler();
		be.setId(b.getId());
		be.setName(b.getName());
		be.setRightHanded(b.isRightHanded());
		be.setSpell(b.getSpell());
		return be;
	}

	private Trajectory prepare(TrajectoryEntity t) {
		Trajectory te = new Trajectory();
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
		te.setBatStatPosition(prepare(t.getBatStatPosition()));
		te.setBouncePosition(prepare(t.getBouncePosition()));
		te.setCreasePosition(prepare(t.getCreasePosition()));
		te.setImpactPosition(prepare(t.getImpactPosition()));
		te.setLandingPosition(prepare(t.getLandingPosition()));
		te.setReleasePosition(prepare(t.getReleasePosition()));
		te.setStumpPosition(prepare(t.getStumpPosition()));
		return te;
	}

	private StumpPosition prepare(StumpPositionEntity sp) {
		StumpPosition spe = new StumpPosition();
		spe.setX(sp.getX());
		spe.setY(sp.getY());
		spe.setZ(sp.getZ());
		return spe;
	}

	private ReleasePosition prepare(ReleasePositionEntity rp) {
		ReleasePosition rpe = new ReleasePosition();
		rpe.setX(rp.getX());
		rpe.setY(rp.getY());
		rpe.setZ(rp.getZ());
		return rpe;
	}

	private LandingPosition prepare(LandingPositionEntity lp) {
		LandingPosition lpe = new LandingPosition();
		lpe.setX(lp.getX());
		lpe.setY(lp.getY());
		lpe.setZ(lp.getZ());
		return lpe;
	}

	private ImpactPosition prepare(ImpactPositionEntity ip) {
		ImpactPosition ipe = new ImpactPosition();
		ipe.setX(ip.getX());
		ipe.setY(ip.getY());
		ipe.setZ(ip.getZ());
		return ipe;
	}

	private CreasePosition prepare(CreasePositionEntity cp) {
		CreasePosition cpe = new CreasePosition();
		cpe.setX(cp.getX());
		cpe.setY(cp.getY());
		cpe.setZ(cp.getZ());
		return cpe;
	}

	private BouncePosition prepare(BouncePositionEntity bp) {
		BouncePosition bpe = new BouncePosition();
		bpe.setX(bp.getX());
		bpe.setY(bp.getY());
		bpe.setZ(bp.getZ());
		return bpe;
	}

	private BatStatPosition prepare(BatStatPositionEntity bp) {
		BatStatPosition bpe = new BatStatPosition();
		bpe.setX(bp.getX());
		bpe.setY(bp.getY());
		return bpe;
	}

	private ShotInformation prepare(ShotInfoEntity si) {
		ShotInformation sie = new ShotInformation();
		sie.setBatsmanWeight( si.getBatsmanWeight());
		sie.setShotAttacked( si.getShotAttacked());
		sie.setShotPlayed( si.getShotPlayed());
		sie.setShotTypeAdditional( si.getShotTypeAdditional());

		return sie;
	}

	private ScoringInformation prepare(ScoringInfoEntity si) {
		ScoringInformation sie = new ScoringInformation();
		sie.setBoundary(si.isBoundary());
		sie.setExtrasScore(si.getExtrasScore());
		sie.setExtrasType(si.getExtrasType());
		sie.setOverthrowScore(si.isOverthrowScore());
		sie.setScore(si.getScore());
		sie.setWicket(preapare( si.getWicket()));
		return sie;
	}

	private Wicket preapare(WicketEntity w) {
		Wicket we = new Wicket();
		we.setWicket(w.isWicket());
		we.setWicketsTaken(w.isWicketsTaken());
		we.setWicketType(w.getWicketType());
		return we;
	}

	private FielderPosition prepare(FielderPositionEntity fp) {
		FielderPosition fpe = new FielderPosition();
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

	private DeliveryNumber prepare(DeliveryNumberEntity dn) {
		DeliveryNumber dne = new DeliveryNumber();
		dne.setBall(dn.getBall());
		dne.setDay(dn.getDay());
		dne.setInnings(dn.getInnings());
		dne.setOver(dn.getOver());
		return dne;
	}

	private AdditionalEventInformation prepare(AdditionalEventInfoEntity ai) {
		AdditionalEventInformation aie = new AdditionalEventInformation();
		aie.setDropped(ai.isDropped());
		return aie;
	}
}
