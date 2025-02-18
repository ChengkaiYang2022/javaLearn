package com.github.yck.pattern.behavioral.structurelike.command.tvcommand;

public class TVCommandOn implements Command {
    private TvReceiver tvReceiver;

    public TVCommandOn(TvReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void execute() {
        tvReceiver.turnOn();tvReceiver.CCTV();
    }

    @Override
    public void undo() {
        tvReceiver.turnOff();
    }
}
